package ru.relex.cryptoexg.user.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class UserShortResponseDto {
    @JsonProperty("secret_key")
    private String secretKey;
}
