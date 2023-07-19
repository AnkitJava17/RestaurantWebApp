package com.mock.auth.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code= HttpStatus.NOT_FOUND, reason ="User already exists")
public class UserAlreadyExistsException extends Exception{
    
}
