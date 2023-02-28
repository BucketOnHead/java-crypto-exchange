package ru.relex.cryptoexg.user.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.relex.cryptoexg.currency.CurrencyName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("java:S116")
public class GetMoneyRequestDto {
    @NotBlank
    @JsonProperty("secret_key")
    private String secretKey;

    @NotNull
    private CurrencyName currency;

    @NotNull
    @Positive
    private Double count;

    @JsonProperty("credit_card")
    private String creditCard;

    private String wallet;
}
