package edu.uml.bcabral.stocktrader.util;

public class InvalidXMLException extends Exception {

    /**
     * Creates a new excception based on a specific message, and
     * cause. (suppression enabled/disabled, stack trace enabled/disabled)
     *
     * @param message           the detailed message for the exception
     * @param cause             the cause of the exception
     *                          (a null value is permitted, meaning cause is unknown
     */

    protected InvalidXMLException(String message, Throwable cause){
        super(message, cause);
    }
}
