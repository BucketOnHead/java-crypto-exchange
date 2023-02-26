package ru.relex.cryptoexg.advice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    private String reason;
    private String message;

    @JsonInclude(Include.NON_NULL)
    private Iterable<String> errors;
}
