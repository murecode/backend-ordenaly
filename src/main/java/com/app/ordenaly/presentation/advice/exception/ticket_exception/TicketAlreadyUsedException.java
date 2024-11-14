package com.app.ordenaly.presentation.advice.exception.ticket_exception;

public class TicketAlreadyUsedException extends RuntimeException {
    public TicketAlreadyUsedException(String message) {
        super(message);
    }
}
