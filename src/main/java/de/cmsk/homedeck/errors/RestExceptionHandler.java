package de.cmsk.homedeck.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings("unused")
    @ExceptionHandler(RestException.class)
    @ResponseBody
    ResponseEntity<ErrorInfo> handleException(HttpServletRequest req, RestException ex) {
        return new ResponseEntity<>(ErrorInfo.builder()
                .errorMessage(ex.getMessage())
                .localizedErrorMessage(ex.getLocalizedMessage())
                .localizedDescription(ex.getLocalizedDescription())
                .requestUrl(req.getRequestURI())
                .timestamp(req.getSession().getCreationTime())
                .httpMethod(req.getMethod().toUpperCase())
                .build(), ex.getHttpStatus());
    }
}

