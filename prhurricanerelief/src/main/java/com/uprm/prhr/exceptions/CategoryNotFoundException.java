package com.uprm.prhr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException
{
    public CategoryNotFoundException(String categoryId)
    {
        super("could not find category " + categoryId + ". ");
    }
}
