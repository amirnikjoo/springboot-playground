package com.amir.levant.dto;

import lombok.Data;

@Data
public class BankInquiryResponseDto {
    private String requestId;
    private String nationalCode;
    private String pan;
    private String accountNumber;
    private String response;

}