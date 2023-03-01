package ru.relex.cryptoexg.admin.logger;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import ru.relex.cryptoexg.admin.dto.request.UpdateRateRequestDto;

@UtilityClass
public final class AdminControllerLoggerHelper {

    public static void updateRate(
            Logger log,
            UpdateRateRequestDto rateDto
    ) {
        log.info("update RATE["
                        + "secret_key='{}'"
                        + "base_currency='{}', "
                        + "BTC={}, "
                        + "TON={}, "
                        + "RUB={}, "
                        + "..."
                        + "].",
                rateDto.getSecretKey(),
                rateDto.getBaseCurrency(),
                rateDto.getBtc(),
                rateDto.getTon(),
                rateDto.getRub());
    }
}
