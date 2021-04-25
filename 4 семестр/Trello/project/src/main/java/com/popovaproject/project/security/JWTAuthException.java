package com.popovaproject.project.security;

import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

public class JWTAuthException extends AuthenticationException {
    private HttpStatus httpStatus;

    public JWTAuthException(String msg) {
        super(msg);
    }

    public JWTAuthException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
