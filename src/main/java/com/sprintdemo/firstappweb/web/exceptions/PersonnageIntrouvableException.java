package com.sprintdemo.firstappweb.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;//HttpStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonnageIntrouvableException extends RuntimeException {
    public PersonnageIntrouvableException() {
        super();
    }
}
