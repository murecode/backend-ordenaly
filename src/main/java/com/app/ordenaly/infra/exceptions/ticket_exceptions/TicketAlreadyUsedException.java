package com.app.ordenaly.infra.exceptions.ticket_exceptions;

public class TicketAlreadyUsedException extends RuntimeException {
    public TicketAlreadyUsedException(String message) {
        super(message);
    }
}
