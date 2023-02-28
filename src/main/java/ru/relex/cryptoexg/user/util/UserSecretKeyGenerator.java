package ru.relex.cryptoexg.user.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import ru.relex.cryptoexg.key.entity.SecretKey;

@UtilityClass
public final class UserSecretKeyGenerator {
    public static final int LENGTH = 34;
    public static final boolean INCLUDE_LETTERS = true;
    public static final boolean INCLUDE_NUMBERS = true;

    public static SecretKey generateSecretKey() {
        String value = RandomStringUtils.random(LENGTH, INCLUDE_LETTERS, INCLUDE_NUMBERS);

        SecretKey key = new SecretKey();
        key.setAccessType(SecretKey.AccessType.USER);
        key.setValue(value);

        return key;
    }
}
