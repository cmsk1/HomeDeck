package de.cmsk.homedeck.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {

    private String errorMessage;
    private String localizedErrorMessage;
    private String localizedDescription;
    private String requestUrl;
    private long timestamp;
    private String httpMethod;
}