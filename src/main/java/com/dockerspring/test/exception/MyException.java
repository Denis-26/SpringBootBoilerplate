package com.dockerspring.test.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }
}
