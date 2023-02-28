package ru.relex.cryptoexg.user.mapper;

import lombok.experimental.UtilityClass;
import ru.relex.cryptoexg.currency.BTC;
import ru.relex.cryptoexg.currency.RUB;
import ru.relex.cryptoexg.currency.TON;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserUpdatedBalanceResponseDto;
import ru.relex.cryptoexg.user.entity.User;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;

import java.util.List;

@UtilityClass
public final class UserMapper {

    public static User toUser(AddUserRequestDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public static UserShortResponseDto toUserShortResponseDto(User user) {
        var responseDto = new UserShortResponseDto();

        responseDto.setSecretKey(user.getSecretKey());

        return responseDto;
    }

    @SuppressWarnings("java:S112")
    public static UserBalanceFullResponseDto toUserBalanceFullResponseDto(User user) {
        var responseDto = new UserBalanceFullResponseDto();

        List<Wallet> wallets = user.getWallets();
        for (Wallet wallet : wallets) {
            switch (wallet.getCurrencyName()) {
                case BTC -> {
                    BTC btc = new BTC(wallet.getMantis(), wallet.getExponent());
                    responseDto.setBtcWallet(btc.toStringValue());
                }
                case TON -> {
                    TON ton = new TON(wallet.getMantis(), wallet.getExponent());
                    responseDto.setTonWallet(ton.toStringValue());
                }
                case RUB -> {
                    RUB rub = new RUB(wallet.getMantis(), wallet.getExponent());
                    responseDto.setRubWallet(rub.toStringValue());
                }
                default -> throw new RuntimeException("Currency '%s' not configured");
            }
        }

        return responseDto;
    }

    public static UserUpdatedBalanceResponseDto toUserUpdatedBalanceResponseDto(Iterable<Wallet> wallets) {
        var updatedBalanceDto = new UserUpdatedBalanceResponseDto();

        for (Wallet wallet : wallets) {
            if (wallet == null) {
                continue;
            }

            switch (wallet.getCurrencyName()) {
                case BTC -> {
                    BTC btc = new BTC(wallet.getMantis(), wallet.getExponent());
                    updatedBalanceDto.setBtcWallet(btc.toStringValue());
                }
                case TON -> {
                    TON ton = new TON(wallet.getMantis(), wallet.getExponent());
                    updatedBalanceDto.setTonWallet(ton.toStringValue());
                }
                case RUB -> {
                    RUB rub = new RUB(wallet.getMantis(), wallet.getExponent());
                    updatedBalanceDto.setRubWallet(rub.toStringValue());
                }
                default -> throw new RuntimeException(String.format(
                        "Currency '%s' not configured", wallet.getCurrencyName()));
            }
        }

        return updatedBalanceDto;
    }
}
