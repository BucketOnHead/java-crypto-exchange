package ru.relex.cryptoexg.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.cryptoexg.admin.dto.request.UpdateRateRequestDto;
import ru.relex.cryptoexg.admin.dto.response.RateResponseDto;
import ru.relex.cryptoexg.admin.service.AdminService;

@Service
@Transactional(readOnly = true)
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Override
    @Transactional
    public RateResponseDto updateRate(UpdateRateRequestDto rateDto) {
        return null;
    }
}
