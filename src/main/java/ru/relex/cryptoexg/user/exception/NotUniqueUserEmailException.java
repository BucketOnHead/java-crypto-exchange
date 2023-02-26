package ru.relex.cryptoexg.user.exception;

import ru.relex.cryptoexg.exception.NotUniqueElementException;

public class NotUniqueUserEmailException extends NotUniqueElementException {
    public static final String NOT_UNIQUE_USER_EMAIL = "User with email='%s' already exists";

    public NotUniqueUserEmailException(String message) {
        super(message);
    }

    public static NotUniqueUserEmailException fromUserEmail(String email) {
        var message = String.format(NOT_UNIQUE_USER_EMAIL, email);
        return new NotUniqueUserEmailException(message);
    }
}
