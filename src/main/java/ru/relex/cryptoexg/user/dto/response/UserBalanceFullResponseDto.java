package ru.relex.cryptoexg.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("java:S116")
public class UserBalanceFullResponseDto {
    @JsonProperty("BTC_wallet")
    private String btcWallet;

    @JsonProperty("TON_wallet")
    private String tonWallet;

    @JsonProperty("RUB_wallet")
    private String rubWallet;
}
