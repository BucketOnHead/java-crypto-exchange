package ru.relex.cryptoexg.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class UserBalanceFullResponseDto {
    private String BTC_wallet;
    private String TON_wallet;
    private String RUB_wallet;
}
