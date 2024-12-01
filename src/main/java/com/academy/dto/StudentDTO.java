package com.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private String id;
    @NotNull
    @Size(min = 2, max = 30)
    private String names;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastNames;
    @NotNull
    @Pattern(regexp = "^[0-9]{8}+$", message = "El DNI debe contener exactamente 8 dígitos.")
    private String dni;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;
}
