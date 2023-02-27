package ru.relex.cryptoexg.user.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.user.dto.request.AddMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.request.GetMoneyRequestDto;

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

    public static void addMoney(
            Logger log,
            AddMoneyRequestDto moneyDto
    ) {
        log.info("add USER_MONEY["
                        + "BTC={}, "
                        + "TON={}, "
                        + "RUB={}, "
                        + "..."
                        + "].",
                moneyDto.getBTC_wallet(),
                moneyDto.getTON_wallet(),
                moneyDto.getRUB_wallet());
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

    public static void getMoney(
            Logger log,
            GetMoneyRequestDto moneyDto
    ) {
        log.info("add USER_MONEY["
                        + "secret_key='{}', "
                        + "currency_name='{}', "
                        + "count={}, "
                        + "credit_card='{}', "
                        + "wallet='{}'"
                        + "].",
                moneyDto.getSecret_key(),
                moneyDto.getCurrency(),
                moneyDto.getCount(),
                moneyDto.getCredit_card(),
                moneyDto.getWallet());
    }
}
