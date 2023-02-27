package ru.relex.cryptoexg.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.request.AddMoneyRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserUpdatedBalanceResponseDto;
import ru.relex.cryptoexg.user.logger.UserControllerLoggerHelper;
import ru.relex.cryptoexg.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserShortResponseDto addUser(
            @RequestBody @Valid AddUserRequestDto userDto
    ) {
        UserControllerLoggerHelper.addUser(log, userDto);
        return userService.addUser(userDto);
    }

    @GetMapping("/wallet")
    public UserBalanceFullResponseDto getUserBalance(
            @RequestHeader("secret_key") String secretKey
    ) {
        UserControllerLoggerHelper.getUserBalance(log, secretKey);
        return userService.getUserBalance(secretKey);
    }

    @PostMapping("/wallet/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public UserUpdatedBalanceResponseDto addMoney(
            @RequestBody @Valid AddMoneyRequestDto moneyDto
    ) {
        UserControllerLoggerHelper.addMoney(log, moneyDto);
        return userService.addMoney(moneyDto);
    }
}
