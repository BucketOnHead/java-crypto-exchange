package ru.relex.cryptoexg.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class UserUpdatedBalanceResponseDto {
    @JsonProperty("BTC_wallet")
    private String BTC_wallet;

    @JsonProperty("TON_wallet")
    private String TON_wallet;

    @JsonProperty("RUB_wallet")
    private String RUB_wallet;
}
