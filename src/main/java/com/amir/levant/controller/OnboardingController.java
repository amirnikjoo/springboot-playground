package com.amir.levant.controller;

import com.amir.levant.dto.BankInquiryDto;
import com.amir.levant.dto.ResponseDto;
import com.amir.levant.service.BankInquiryService;
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

        bankInquiryService.doRegister(inputDto);
        return ResponseEntity.ok().build();

    }
}
