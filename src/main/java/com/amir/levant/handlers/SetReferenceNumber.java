package com.amir.levant.handlers;

import com.amir.levant.constants.PaymentConstants;
import com.amir.levant.core.IHandler;
import com.amir.levant.util.MyUtility;

import java.util.Map;

public class SetReferenceNumber extends IHandler {

    @Override
    public void process(Map map) throws Exception {
        map.put(PaymentConstants.REQUEST_TIME, System.currentTimeMillis());
        String refNo = MyUtility.generateRefNo1();
        log.info("---- inside ---- {} ", refNo);

        map.put(PaymentConstants.START_TIME, System.currentTimeMillis());
        map.put(PaymentConstants.REF_NUMBER, refNo); // set UUID
    }
}
