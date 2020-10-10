package edu.uml.bcabral.stocktrader.services;

public class PersonServiceException extends Exception{
    /**
     * Constructs a new exception with the specific message and cause
     *
     * @param message detailed message.
     * @param cause the cause of the thrown exception, can be null
     *              if unknown.
     */
    public PersonServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
