package ru.relex.cryptoexg.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.relex.cryptoexg.advice.response.ErrorResponse;
import ru.relex.cryptoexg.advice.util.ErrorExtractor;
import ru.relex.cryptoexg.exception.NotUniqueElementException;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler({NotUniqueElementException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse notUniqueElementExceptionHandler(final Exception ex) {
        String reason = "Violation of uniqueness";
        log.error(reason + ": {}.", ex.getMessage());
        return ErrorResponse.builder()
                .reason(reason)
                .message(ex.getMessage())
                .errors(ErrorExtractor.extractErrors(ex))
                .build();
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse throwableHandler(final Throwable ex) {
        String reason = "Unexpected server error";
        log.error(reason + ": {}.", ex.getMessage());
        return ErrorResponse.builder()
                .reason(reason)
                .message(ex.getMessage())
                .errors(ErrorExtractor.extractErrors(ex))
                .build();
    }
}
