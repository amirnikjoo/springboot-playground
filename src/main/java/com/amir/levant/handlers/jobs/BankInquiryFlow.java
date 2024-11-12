package com.amir.levant.handlers.jobs;


import com.amir.levant.core.IHandler;

import java.util.Map;

public class BankInquiryFlow extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        processChainHandler(map);
    }
}
