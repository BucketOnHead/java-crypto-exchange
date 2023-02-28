package ru.relex.cryptoexg.user.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class AddMoneyRequestDto {
    @NotBlank
    @JsonProperty("secret_key")
    private String secretKey;

    @Positive
    @JsonProperty("BTC_wallet")
    private Double btcWallet;

    @Positive
    @JsonProperty("TON_wallet")
    private Double tonWallet;

    @Positive
    @JsonProperty("RUB_wallet")
    private Double rubWallet;
}
