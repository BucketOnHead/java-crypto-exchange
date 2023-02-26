package ru.relex.cryptoexg.advice.util;

import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.List;

@UtilityClass
public final class ErrorExtractor {

    @SuppressWarnings("java:S1168")
    public static List<String> extractErrors(Throwable th) {
        if (th.getCause() == null) {
            return null;
        }

        List<String> errors = new LinkedList<>();

        while (th.getCause() != null) {
            th = th.getCause();
            errors.add(th.getMessage());
        }

        return errors;
    }
}
