package ru.relex.cryptoexg.admin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RateResponseDto {
    @JsonProperty("BTC")
    private String btc;

    @JsonProperty("TON")
    private String ton;

    @JsonProperty("RUB")
    private String rub;
}
