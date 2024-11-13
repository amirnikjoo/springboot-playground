package com.kian.card.service;

import com.kian.card.dto.BankInquiryDto;
import com.kian.card.dto.ResponseDto;
import com.kian.card.enums.BankInquiryStatus;
import com.kian.card.model.BankInquiry;

import java.util.List;

public interface BankInquiryService {
    ResponseDto doRegister(BankInquiryDto dto) throws Exception;

    List<BankInquiry> getBankInquiries(BankInquiryStatus status);

}
