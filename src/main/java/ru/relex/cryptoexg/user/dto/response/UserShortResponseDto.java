package ru.relex.cryptoexg.user.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class UserShortResponseDto {
    private String secret_key;
}
