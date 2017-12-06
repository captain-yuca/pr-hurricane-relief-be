package com.uprm.prhr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //TODO: Figure out which error to send
public class MissingParameterException extends RuntimeException
{
    public MissingParameterException()
    {
        super("Could not find parameter required");
    }
}
