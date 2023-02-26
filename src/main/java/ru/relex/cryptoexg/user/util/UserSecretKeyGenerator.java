package ru.relex.cryptoexg.user.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

@UtilityClass
public final class UserSecretKeyGenerator {
    public static final int LENGTH = 34;
    public static final boolean INCLUDE_LETTERS = true;
    public static final boolean INCLUDE_NUMBERS = true;

    public static String generateSecretKey() {
        return RandomStringUtils.random(LENGTH, INCLUDE_LETTERS, INCLUDE_NUMBERS);
    }
}
