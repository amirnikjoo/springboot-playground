package com.amir.levant.service;

import com.amir.levant.dto.BankInquiryDto;
import com.amir.levant.dto.ResponseDto;
import com.amir.levant.dto.TransactionDto;
import com.amir.levant.enums.BankInquiryStatus;
import com.amir.levant.model.BankInquiry;

import java.util.List;

public interface BankInquiryService {
    ResponseDto doRegister(BankInquiryDto dto) throws Exception;

    List<BankInquiry> getBankInquiries(BankInquiryStatus status);

}
