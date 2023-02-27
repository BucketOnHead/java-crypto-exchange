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

        responseDto.setSecret_key(user.getSecretKey());

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
                    responseDto.setBTC_wallet(btc.toStringValue());
                }
                case TON -> {
                    TON ton = new TON(wallet.getMantis(), wallet.getExponent());
                    responseDto.setTON_wallet(ton.toStringValue());
                }
                case RUB -> {
                    RUB rub = new RUB(wallet.getMantis(), wallet.getExponent());
                    responseDto.setRUB_wallet(rub.toStringValue());
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
                    updatedBalanceDto.setBTC_wallet(btc.toStringValue());
                }
                case TON -> {
                    TON ton = new TON(wallet.getMantis(), wallet.getExponent());
                    updatedBalanceDto.setTON_wallet(ton.toStringValue());
                }
                case RUB -> {
                    RUB rub = new RUB(wallet.getMantis(), wallet.getExponent());
                    updatedBalanceDto.setRUB_wallet(rub.toStringValue());
                }
                default -> throw new RuntimeException("Currency '%s' not configured");
            }
        }

        return updatedBalanceDto;
    }
}
