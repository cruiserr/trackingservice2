package edu.iu.c322.trackingservice.handler;

public class InvalidOrderIdorItemIdException extends RuntimeException {
    public InvalidOrderIdorItemIdException(String message) {
        super(message);
    }
}
