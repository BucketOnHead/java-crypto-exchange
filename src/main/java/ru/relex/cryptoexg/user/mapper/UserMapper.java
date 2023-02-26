package ru.relex.cryptoexg.user.mapper;

import lombok.experimental.UtilityClass;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.entity.User;

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
}
