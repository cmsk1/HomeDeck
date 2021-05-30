package de.cmsk.homedeck.errors;

import org.springframework.http.HttpStatus;

public class SignalNotSendException extends RestException {

    public SignalNotSendException() {
        super(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public String getMessage() {
        return "The command could not be sent";
    }

    @Override
    public String getLocalizedMessage() {
        return "Der Befehl konnte nicht gesendet werden.";
    }
}
