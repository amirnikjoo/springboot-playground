package com.amir.levant.dto;

import lombok.Data;

@Data
public class BankInquiryDto {
    private String nationalCode;
    private String bankName;
    private String requestId;

}