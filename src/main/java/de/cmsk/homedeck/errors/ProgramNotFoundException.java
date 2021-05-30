package de.cmsk.homedeck.errors;

import org.springframework.http.HttpStatus;

public class ProgramNotFoundException extends RestException {

    public ProgramNotFoundException() {
        super(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public String getMessage() {
        return "The program to execute the command was not found.";
    }

    @Override
    public String getLocalizedMessage() {
        return "Das Programm zu ausführen des Befehls, wurde nicht gefunden.";
    }
}
