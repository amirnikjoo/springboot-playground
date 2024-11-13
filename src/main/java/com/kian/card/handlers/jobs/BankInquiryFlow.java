package com.kian.card.handlers.jobs;


import com.kian.card.core.IHandler;

import java.util.Map;

public class BankInquiryFlow extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        processChainHandler(map);
    }
}
