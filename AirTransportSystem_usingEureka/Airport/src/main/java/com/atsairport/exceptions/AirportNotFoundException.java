package com.atsairport.exceptions;

public class AirportNotFoundException extends RuntimeException{
    public AirportNotFoundException(String message)
    {
        super(message);
    }
    public AirportNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
