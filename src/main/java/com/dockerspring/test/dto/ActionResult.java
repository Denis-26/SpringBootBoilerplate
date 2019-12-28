package com.dockerspring.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ActionResult<T> {

    private T value;
    private boolean success;
    private Integer errorCode;
    private String message;

    @SuppressWarnings("unchecked")
    public static <T> ActionResult<T> ok(T value) {
        return new ActionResult<T>()
                .setSuccess(true)
                .setValue(value);
    }

    public static ActionResult ok() {
        return new ActionResult().setSuccess(true);
    }

    public static <T> ActionResult<T> fail(HttpStatus status) {
        return fail(status, null);
    }

    public static <T> ActionResult<T> fail(HttpStatus status, String message) {
        return new ActionResult<T>()
                .setErrorCode(status.value())
                .setMessage(message)
                .setSuccess(false);
    }

    public static ActionResult<List<ErrorResponse>> fail(List<FieldError> errorList){
        return new ActionResult<List<ErrorResponse>>()
                .setSuccess(false)
                .setErrorCode(HttpStatus.BAD_REQUEST.value())
                .setValue(ErrorResponse.errorsList(errorList));
    }
}

