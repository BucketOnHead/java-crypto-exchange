package ru.relex.cryptoexg.user.dto.request;

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
    private String secret_key;

    @NotNull
    private CurrencyName currency;

    @NotNull
    @Positive
    private Double count;

    private String credit_card;

    private String wallet;
}
