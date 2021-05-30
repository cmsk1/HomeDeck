package de.cmsk.homedeck.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RestException extends Exception {

    private final HttpStatus httpStatus;
    private final String localizedDescription;

    @SuppressWarnings("unused")
    public RestException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.localizedDescription = "";
    }
}