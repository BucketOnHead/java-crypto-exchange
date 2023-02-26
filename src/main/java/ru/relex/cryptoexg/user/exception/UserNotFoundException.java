package ru.relex.cryptoexg.user.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public static final String USER_NOT_FOUND_BY_SECRET_KEY = "User with secret_key='%s' not found";

    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException fromSecretKey(String secretKey) {
        var message = String.format(USER_NOT_FOUND_BY_SECRET_KEY, secretKey);
        return new UserNotFoundException(message);
    }
}
