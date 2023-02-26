package ru.relex.cryptoexg.user.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.user.entity.User;

@UtilityClass
public final class UserServiceLoggerHelper {

    public static void userSaved(
            Logger log,
            User user
    ) {
        log.info("USER["
                        + "id={}, "
                        + "secret_key='{}'"
                        + "] saved.",
                user.getId(),
                user.getSecretKey());
    }
}
