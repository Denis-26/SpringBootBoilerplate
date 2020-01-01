package com.dockerspring.test.dto;

import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String fieldName;
    private String errorMessage;

    public static List<ErrorResponse> errorsList(List<FieldError> errors) {
        return errors.stream()
                .map(error -> ErrorResponse.builder()
                        .fieldName(error.getField())
                        .errorMessage(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }
}
