package com.academy.validator;

import com.academy.dto.ValidationDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RequestValidator {

    private final Validator validator;

    public <T> Mono<T> validate(T t){
        if(t == null) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }

        Set<ConstraintViolation<T>> constraint = validator.validate(t);

        if(constraint == null || constraint.isEmpty()) {
            return Mono.just(t);
        }

        String errorMessage = constraint.stream()
                .map(violation -> String.format("Campo '%s': %s",
                        violation.getPropertyPath(),
                        violation.getMessage()))
                .collect(Collectors.joining(", "));

        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage));
    }
}