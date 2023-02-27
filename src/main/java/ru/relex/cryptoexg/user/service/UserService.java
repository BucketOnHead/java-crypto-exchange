package ru.relex.cryptoexg.user.service;

import ru.relex.cryptoexg.user.dto.request.AddMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.request.GetMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserUpdatedBalanceResponseDto;

public interface UserService {
    UserShortResponseDto addUser(AddUserRequestDto userDto);

    UserUpdatedBalanceResponseDto addMoney(AddMoneyRequestDto moneyDto);

    UserBalanceFullResponseDto getUserBalance(String secretKey);

    UserUpdatedBalanceResponseDto getMoney(GetMoneyRequestDto moneyDto);
}
