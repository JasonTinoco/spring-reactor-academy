package com.academy.handler;

import com.academy.dto.StudentDTO;
import com.academy.model.Student;
import com.academy.service.IStudentService;
import com.academy.validator.RequestValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Comparator;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class StudentHandler {

    private final IStudentService service;
    private final ModelMapper modelMapper;
    private final RequestValidator requestValidator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll().map(this::convertToDto), StudentDTO.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id)
                .map(this::convertToDto)
                .flatMap(e -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(e))
                ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<StudentDTO> monoClientDTO = request.bodyToMono(StudentDTO.class);

        return monoClientDTO
                .flatMap(requestValidator::validate)
                .flatMap(e -> service.save(convertToDocument(e)))
                .map(this::convertToDto)
                .flatMap(e -> ServerResponse
                        .created(URI.create(request.uri().toString().concat("/").concat(e.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(e))
                );
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");

        return request.bodyToMono(StudentDTO.class)
                .map(e -> {
                    e.setId(id);
                    return e;
                })
                .flatMap(requestValidator::validate)
                .flatMap(e -> service.update(id, convertToDocument(e)))
                .map(this::convertToDto)
                .flatMap(e -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(e))
                );
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");

        return service.delete(id)
                .flatMap(result -> result ? ServerResponse.noContent().build() : ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAllSortAge(ServerRequest request) {
        String order = request.queryParam("order").orElse("asc");

        return service.findAll()
                .map(this::convertToDto)
                .sort(order.equalsIgnoreCase("desc") ?
                        Comparator.comparing(StudentDTO::getAge).reversed() :
                        Comparator.comparing(StudentDTO::getAge))
                .collectList()
                .flatMap(e -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(e))
                );
    }

    private StudentDTO convertToDto(Student model) {
        return modelMapper.map(model, StudentDTO.class);
    }

    private Student convertToDocument(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}
