package ru.relex.cryptoexg.user.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.entity.User;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;

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

    public static void userWalletSaved(
            Logger log,
            Wallet wallet
    ) {
        log.debug("USER_WALLET["
                        + "wallet_id={}, "
                        + "user_id={}, "
                        + "currency_name='{}'"
                        + "] saved.",
                wallet.getId(),
                wallet.getUser().getId(),
                wallet.getCurrencyName());
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
                balanceFullResponseDto.getBtcWallet(),
                balanceFullResponseDto.getTonWallet(),
                balanceFullResponseDto.getRubWallet());
    }

    public static void userWalletUpdated(
            Logger log,
            Wallet wallet
    ) {
        log.info("USER_WALLET["
                        + "wallet_id={}, "
                        + "user_id={}, "
                        + "currency_name='{}', "
                        + "mantis={}, "
                        + "exponent={}"
                        + "] updated.",
                wallet.getId(),
                wallet.getUser().getId(),
                wallet.getCurrencyName(),
                wallet.getMantis(),
                wallet.getExponent());
    }
}
