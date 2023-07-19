package com.mock.auth.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code= HttpStatus.NOT_FOUND, reason ="User doesn't exists with these credentials")
public class UserNotFoundException extends Exception{
    
}
