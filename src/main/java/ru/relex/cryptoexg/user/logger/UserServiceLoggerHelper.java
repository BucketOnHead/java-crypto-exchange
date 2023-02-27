package ru.relex.cryptoexg.user.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
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

    public static void userFullBalanceReturned(
            Logger log,
            UserBalanceFullResponseDto balanceFullResponseDto
    ) {
        log.info("USER_BALANCE["
                        + "BTC={}, "
                        + "TON={}, "
                        + "RUB={}, "
                        + "..."
                        + "] returned.",
                balanceFullResponseDto.getBTC_wallet(),
                balanceFullResponseDto.getTON_wallet(),
                balanceFullResponseDto.getRUB_wallet());
    }
}
