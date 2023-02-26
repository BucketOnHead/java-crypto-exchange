package ru.relex.cryptoexg.user.exception;

import ru.relex.cryptoexg.exception.NotUniqueElementException;

public class NotUniqueUserUsernameException extends NotUniqueElementException {
    public static final String NOT_UNIQUE_USERNAME = "User with username='%s' already exists";

    public NotUniqueUserUsernameException(String message) {
        super(message);
    }

    public static NotUniqueUserUsernameException fromUserName(String username) {
        var message = String.format(NOT_UNIQUE_USERNAME, username);
        return new NotUniqueUserUsernameException(message);
    }
}
