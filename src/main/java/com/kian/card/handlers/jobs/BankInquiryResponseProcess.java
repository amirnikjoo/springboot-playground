package com.kian.card.handlers.jobs;


import com.kian.card.core.Constants;
import com.kian.card.core.IHandler;
import com.kian.card.dto.BankInquiryResponseDto;
import com.kian.card.enums.BankInquiryStatus;
import com.kian.card.model.BankInquiry;
import com.kian.card.repository.BankInquiryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public class BankInquiryResponseProcess extends IHandler {

    BankInquiryRepository bankInquiryRepository;

    public BankInquiryResponseProcess(BankInquiryRepository bankInquiryRepository) {
        this.bankInquiryRepository = bankInquiryRepository;
    }

    @Override
    @Transactional
    public void process(Map map) throws Exception {
        Long refNo = (Long) map.get(Constants.REF_NO);
        log.info("---- inside ---- {}", refNo);

        BankInquiry bankInquiry = (BankInquiry) map.get(Constants.BANK_INQUIRY_ENTITY);
        BankInquiryResponseDto responseDto = (BankInquiryResponseDto) map.get(Constants.BANK_INQUIRY_RESPONSE_OBJECT);

        if (responseDto.getResponse().equals("APPROVED")) {
            log.info("update status to approved {}", refNo);
            bankInquiryRepository.updateBankInquiriesByStatus(bankInquiry.getId(), BankInquiryStatus.APPROVED);
            log.info("persist to account table {}", refNo);

        } else {
            log.info("update status to rejected {}", refNo);
        }

    }
}
