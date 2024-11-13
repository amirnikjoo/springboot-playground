package com.kian.card.handlers.jobs;


import com.kian.card.core.Constants;
import com.kian.card.core.IHandler;
import com.kian.card.dto.BankInquiryResponseDto;
import com.kian.card.model.BankInquiry;

import java.util.Map;

public class CallBank extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        Long refNo = (Long) map.get(Constants.REF_NO);
        log.info("---- inside ---- {}", refNo);

        BankInquiry bankInquiry = (BankInquiry) map.get(Constants.BANK_INQUIRY_ENTITY);

        BankInquiryResponseDto responseDto = new BankInquiryResponseDto();
        responseDto.setRequestId(bankInquiry.getRequestId());
        responseDto.setResponse("APPROVED");
        responseDto.setPan("1234567890123456");
        responseDto.setNationalCode("0059392401");
        responseDto.setAccountNumber("11/12/13/58422145");

        map.put(Constants.BANK_INQUIRY_RESPONSE_OBJECT, responseDto);

    }
}
