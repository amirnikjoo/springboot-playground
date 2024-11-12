package com.amir.levant.service;

import com.amir.levant.dto.BankInquiryDto;
import com.amir.levant.dto.ResponseDto;
import com.amir.levant.dto.TransactionDto;

public interface BankInquiryService {
    void doRegister(BankInquiryDto dto) throws Exception;

}
