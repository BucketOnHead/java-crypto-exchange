package ru.relex.cryptoexg.user.exception.wallet;

import ru.relex.cryptoexg.currency.CurrencyName;

import javax.persistence.EntityNotFoundException;

public class WalletNotFoundException extends EntityNotFoundException {
    public static final String WALLET_NOT_FOUND_EXCEPTION = "Wallet[%s] not found for user[%s]";

    public WalletNotFoundException(String message) {
        super(message);
    }

    public static WalletNotFoundException fromSecretKeyAndCurrencyName(String secretKey, CurrencyName currency) {
        var message = String.format(WALLET_NOT_FOUND_EXCEPTION, currency, secretKey);
        return new WalletNotFoundException(message);
    }
}
