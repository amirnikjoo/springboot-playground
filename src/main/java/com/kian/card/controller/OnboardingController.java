package com.kian.card.controller;

import com.kian.card.dto.BankInquiryDto;
import com.kian.card.dto.ResponseDto;
import com.kian.card.service.BankInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/onb")
@Slf4j
public class OnboardingController {
    private final BankInquiryService bankInquiryService;

    public OnboardingController(BankInquiryService bankInquiryService) {
        this.bankInquiryService = bankInquiryService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> doRegister(@RequestBody BankInquiryDto inputDto,
                                                  @RequestHeader Map<String, String> headers) throws Exception {

        log.info("request_body: {} ", inputDto.toString());
        return ResponseEntity.ok(bankInquiryService.doRegister(inputDto));

    }
}
