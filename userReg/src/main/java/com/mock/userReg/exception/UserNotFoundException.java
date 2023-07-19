package com.mock.userReg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason ="User Not present")
public class UserNotFoundException extends RuntimeException {
        
}
