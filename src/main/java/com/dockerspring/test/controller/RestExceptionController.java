package com.dockerspring.test.controller;

import com.dockerspring.test.dto.ActionResult;
import com.dockerspring.test.exception.MyException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestControllerAdvice
public class RestExceptionController {

    private final HttpServletRequest request;

    @Autowired
    public RestExceptionController(HttpServletRequest request) {
        this.request = request;
    }

    @ExceptionHandler(Exception.class)
    public ActionResult handleException(Exception e){
        log.error("Error occurred while handling api request. URL {}, Method {}, Headers {}",
                ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
                request.getMethod(), this.getRequestHeaders(), e);
        return ActionResult.fail(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MyException.class)
    public ActionResult handleMyException(MyException e){
        return ActionResult.fail(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ActionResult handleNoHandlerFoundException(){
        return ActionResult.fail(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ActionResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ActionResult.fail(e.getBindingResult().getFieldErrors());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ActionResult handleAccessDeniedException(){
        return ActionResult.fail(HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ActionResult handleAuthenticationException(){
        return ActionResult.fail(HttpStatus.UNAUTHORIZED);
    }

    private Map<String, Object> getRequestHeaders(){
        Map<String, Object> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }

        return headers;
    }

}
