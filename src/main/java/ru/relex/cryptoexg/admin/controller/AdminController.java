package ru.relex.cryptoexg.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.relex.cryptoexg.admin.dto.request.UpdateRateRequestDto;
import ru.relex.cryptoexg.admin.dto.response.RateResponseDto;
import ru.relex.cryptoexg.admin.logger.AdminControllerLoggerHelper;
import ru.relex.cryptoexg.admin.service.AdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admins")
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/rate")
    @ResponseStatus(HttpStatus.CREATED)
    public RateResponseDto updateRate(
            @RequestBody @Valid UpdateRateRequestDto rateDto
    ) {
        AdminControllerLoggerHelper.updateRate(log, rateDto);
        return adminService.updateRate(rateDto);
    }

    // TODO: GET /admins/wallets/sum?currency=?
    // TODO: GET/admins/transactions/count?from=?&to=?
}
