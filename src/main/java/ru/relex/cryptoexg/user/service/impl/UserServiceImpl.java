package ru.relex.cryptoexg.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.cryptoexg.currency.BTC;
import ru.relex.cryptoexg.currency.CurrencyName;
import ru.relex.cryptoexg.currency.RUB;
import ru.relex.cryptoexg.currency.TON;
import ru.relex.cryptoexg.exception.status.BadRequestException;
import ru.relex.cryptoexg.user.dto.request.AddMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.request.GetMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserUpdatedBalanceResponseDto;
import ru.relex.cryptoexg.user.entity.User;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;
import ru.relex.cryptoexg.user.exception.wallet.WalletNotFoundException;
import ru.relex.cryptoexg.user.logger.UserServiceLoggerHelper;
import ru.relex.cryptoexg.user.mapper.UserMapper;
import ru.relex.cryptoexg.user.repository.UserJpaRepository;
import ru.relex.cryptoexg.user.repository.wallet.WalletJpaRepository;
import ru.relex.cryptoexg.user.service.UserService;
import ru.relex.cryptoexg.user.util.UserSecretKeyGenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userRepository;
    private final WalletJpaRepository walletRepository;

    @Override
    @Transactional
    public UserShortResponseDto addUser(AddUserRequestDto userDto) {
        userRepository.checkUniqueEmail(userDto.getEmail());
        userRepository.checkUniqueUsername(userDto.getUsername());
        User user = UserMapper.toUser(userDto);
        user.setSecretKey(getSecretKey());
        User savedUser = userRepository.save(user);
        UserServiceLoggerHelper.userSaved(log, savedUser);
        return UserMapper.toUserShortResponseDto(savedUser);
    }

    @Override
    @Transactional
    public UserUpdatedBalanceResponseDto addMoney(AddMoneyRequestDto moneyDto) {
        User user = userRepository.getReferenceBySecretKey(moneyDto.getSecret_key());

        List<Wallet> updatedWallets = new LinkedList<>();

        if (moneyDto.getBTC_wallet() != null) {
            Wallet btcWallet = getOrCreateWallet(user, CurrencyName.BTC);

            BTC btc = new BTC(btcWallet.getMantis(), btcWallet.getExponent());
            btc.plus(new BTC(moneyDto.getBTC_wallet()));

            btcWallet.setMantis(btc.getMantis());
            btcWallet.setExponent(btc.getExponent());

            Wallet updatedWallet = walletRepository.save(btcWallet);
            UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            updatedWallets.add(updatedWallet);
        }

        if (moneyDto.getTON_wallet() != null) {
            Wallet tonWallet = getOrCreateWallet(user, CurrencyName.TON);

            TON ton = new TON(tonWallet.getMantis(), tonWallet.getExponent());
            ton.plus(new TON(moneyDto.getTON_wallet()));

            tonWallet.setMantis(ton.getMantis());
            tonWallet.setExponent(ton.getExponent());

            Wallet updatedWallet = walletRepository.save(tonWallet);
            UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            updatedWallets.add(updatedWallet);
        }

        if (moneyDto.getRUB_wallet() != null) {
            Wallet rubWallet = getOrCreateWallet(user, CurrencyName.RUB);

            RUB rub = new RUB(rubWallet.getMantis(), rubWallet.getExponent());
            rub.plus(new RUB(moneyDto.getRUB_wallet()));

            rubWallet.setMantis(rub.getMantis());
            rubWallet.setExponent(rub.getExponent());

            Wallet updatedWallet = walletRepository.save(rubWallet);
            UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            updatedWallets.add(updatedWallet);
        }

        return UserMapper.toUserUpdatedBalanceResponseDto(updatedWallets);
    }

    @Override
    public UserBalanceFullResponseDto getUserBalance(String secretKey) {
        User user = userRepository.getReferenceBySecretKey(secretKey);
        var balance = UserMapper.toUserBalanceFullResponseDto(user);
        UserServiceLoggerHelper.userFullBalanceReturned(log, balance);
        return balance;
    }

    @Override
    @Transactional
    public UserUpdatedBalanceResponseDto getMoney(GetMoneyRequestDto moneyDto) {
        if (moneyDto.getCredit_card() == null && moneyDto.getWallet() == null) {
            throw new BadRequestException("No output method specified");
        }

        if (moneyDto.getCredit_card() != null && moneyDto.getWallet() != null) {
            throw new BadRequestException("Several output methods are specified");
        }

        User user = userRepository.getReferenceBySecretKey(moneyDto.getSecret_key());

        Wallet wallet = findWallet(user, moneyDto.getCurrency());
        if (wallet == null) {
            throw WalletNotFoundException.fromSecretKeyAndCurrencyName(
                    moneyDto.getSecret_key(), moneyDto.getCurrency());
        }

        Wallet updatedWallet;
        switch (moneyDto.getCurrency()) {
            case BTC -> {
                BTC btc = new BTC(wallet.getMantis(), wallet.getExponent());
                btc.minus(new BTC(moneyDto.getCount()));

                wallet.setMantis(btc.getMantis());
                wallet.setExponent(btc.getExponent());

                updatedWallet = walletRepository.save(wallet);
                UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            }
            case TON -> {
                TON ton = new TON(wallet.getMantis(), wallet.getExponent());
                ton.minus(new TON(moneyDto.getCount()));

                wallet.setMantis(ton.getMantis());
                wallet.setExponent(ton.getExponent());

                updatedWallet = walletRepository.save(wallet);
                UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            }
            case RUB -> {
                RUB rub = new RUB(wallet.getMantis(), wallet.getExponent());
                rub.minus(new RUB(moneyDto.getCount()));

                wallet.setMantis(rub.getMantis());
                wallet.setExponent(rub.getExponent());

                updatedWallet = walletRepository.save(wallet);
                UserServiceLoggerHelper.userWalletUpdated(log, updatedWallet);
            }
            default -> throw new RuntimeException(String.format(
                    "Currency '%s' not configured", moneyDto.getCurrency()));
        }

        if (moneyDto.getCredit_card() != null) {

        } else if (moneyDto.getWallet() != null) {

        }

        return UserMapper.toUserUpdatedBalanceResponseDto(Collections.singletonList(updatedWallet));
    }

    private Wallet getOrCreateWallet(User user, CurrencyName currencyName) {
        Wallet wallet = findWallet(user, currencyName);

        if (wallet == null) {
            wallet = createWallet(user, currencyName);
        }

        return wallet;
    }

    private static Wallet findWallet(User user, CurrencyName currencyName) {
        for (Wallet wallet : user.getWallets()) {
            if (wallet.getCurrencyName() == currencyName) {
                return wallet;
            }
        }

        return null;
    }

    private Wallet createWallet(User user, CurrencyName currencyName) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setCurrencyName(currencyName);

        Wallet savedWallet = walletRepository.save(wallet);
        UserServiceLoggerHelper.userWalletSaved(log, savedWallet);
        return savedWallet;
    }

    private String getSecretKey() {
        String secretKey;

        do {
            secretKey = UserSecretKeyGenerator.generateSecretKey();
        } while (userRepository.existsBySecretKey(secretKey));

        return secretKey;
    }
}
