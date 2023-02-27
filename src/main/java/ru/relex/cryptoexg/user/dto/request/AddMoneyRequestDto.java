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
    private String secret_key;

    @JsonProperty("BTC_wallet")
    @Positive
    private Double BTC_wallet;

    @JsonProperty("TON_wallet")
    @Positive
    private Double TON_wallet;

    @JsonProperty("RUB_wallet")
    @Positive
    private Double RUB_wallet;
}
