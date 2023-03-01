package ru.relex.cryptoexg.admin.dto.request;

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
public class UpdateRateRequestDto {
    @NotBlank
    @JsonProperty("secret_key")
    private String secretKey;

    @NotNull
    @JsonProperty("base_currency")
    private CurrencyName baseCurrency;

    @Positive
    @JsonProperty("BTC")
    private Double btc;

    @Positive
    @JsonProperty("TON")
    private Double ton;

    @Positive
    @JsonProperty("RUB")
    private Double rub;
}
