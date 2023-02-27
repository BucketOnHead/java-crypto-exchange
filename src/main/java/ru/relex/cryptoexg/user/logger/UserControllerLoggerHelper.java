package ru.relex.cryptoexg.user.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;

@UtilityClass
public final class UserControllerLoggerHelper {

    public static void addUser(
            Logger log,
            AddUserRequestDto userDto
    ) {
        log.info("add USER["
                        + "username='{}', "
                        + "email='{}'"
                        + "].",
                userDto.getUsername(),
                userDto.getEmail());
    }

    public static void getUserBalance(
            Logger log,
            String secretKey
    ) {
        log.info("get USER_BALANCE["
                        + "secret_key='{}'"
                        + "].",
                secretKey);
    }
}
