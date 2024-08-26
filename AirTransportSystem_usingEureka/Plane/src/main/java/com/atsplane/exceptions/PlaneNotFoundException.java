package com.atsplane.exceptions;

public class PlaneNotFoundException extends RuntimeException{
    public PlaneNotFoundException(String message)
    {
        super(message);
    }
    public PlaneNotFoundException(String message,Throwable cause)
    {
        super(message, cause);
    }
}
