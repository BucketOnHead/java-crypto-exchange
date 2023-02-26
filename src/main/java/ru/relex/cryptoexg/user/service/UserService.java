package ru.relex.cryptoexg.user.service;

import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;

public interface UserService {
    UserShortResponseDto addUser(AddUserRequestDto userDto);
}
