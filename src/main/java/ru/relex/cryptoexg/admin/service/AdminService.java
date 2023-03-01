package ru.relex.cryptoexg.admin.service;

import ru.relex.cryptoexg.admin.dto.request.UpdateRateRequestDto;
import ru.relex.cryptoexg.admin.dto.response.RateResponseDto;

public interface AdminService {
    RateResponseDto updateRate(UpdateRateRequestDto rateDto);
}
