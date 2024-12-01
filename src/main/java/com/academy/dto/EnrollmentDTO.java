package com.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private String id;
    @NotNull
    private LocalDate dateEnrollment;
    @NotNull
    private StudentDTO student;
    @NotNull
    private List<EnrollmentDetailDTO> courses;
    @NotNull
    private Boolean state;
}
