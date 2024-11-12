package com.amir.levant.handlers.jobs;


import com.amir.levant.core.Constants;
import com.amir.levant.core.IHandler;
import com.amir.levant.model.BankInquiry;

import java.util.Map;

public class BankInquiryPrepareRequest extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        Long refNo = (Long) map.get(Constants.REF_NO);
        log.info("---- inside ---- {}", refNo);

        BankInquiry bankInquiry = (BankInquiry) map.get(Constants.BANK_INQUIRY_ENTITY);
        log.info(" bankInquiryId: {} ", bankInquiry.getId());

    }
}
