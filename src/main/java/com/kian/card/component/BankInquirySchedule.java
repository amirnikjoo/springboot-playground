package com.kian.card.component;

import com.kian.card.core.Constants;
import com.kian.card.core.IHandler;
import com.kian.card.enums.BankInquiryStatus;
import com.kian.card.model.BankInquiry;
import com.kian.card.service.BankInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankInquirySchedule {

    private final IHandler bankInquiryChainHandler;
    private final BankInquiryService bankInquiryService;

//    @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0/10 * * * * ?")
    public void run() throws Exception {

        List<BankInquiry> bankInquiryList = bankInquiryService.getBankInquiries(BankInquiryStatus.CREATED);
        log.info("list size: {}", bankInquiryList.size());
        for (BankInquiry bankInquiry : bankInquiryList) {
            Map map = new HashMap();
            map.put(Constants.BANK_INQUIRY_ENTITY, bankInquiry);
            bankInquiryChainHandler.process(map);
        }
    }
}
