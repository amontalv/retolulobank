package com.lulobank.exceptions;

public class ServicePathException extends AssertionError{

    public ServicePathException(String message, Throwable cause){
        super(message,cause);
    }
}
