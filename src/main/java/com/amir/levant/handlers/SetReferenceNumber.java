package com.amir.levant.handlers;

import com.amir.levant.constants.PaymentConstants;
import com.amir.levant.core.IHandler;
import com.amir.levant.dto.ParameterDto;
import com.amir.levant.repository.ParameterRepository;
import com.amir.levant.service.ParameterService;
import com.amir.levant.util.MyUtility;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class SetReferenceNumber extends IHandler {
    private final ParameterService parameterService;

    @Override
    public void process(Map map) throws Exception {
        map.put(PaymentConstants.REQUEST_TIME, System.currentTimeMillis());
        String refNo = MyUtility.generateRefNo1();
        log.debug("---- inside ---- {} ", refNo);
        log.info("---- inside ---- {} ", refNo);

        ParameterDto parameterById = parameterService.getParameterById(1L);
        log.info("---- parameter 1 ---- {} ", parameterById);
        map.put(PaymentConstants.START_TIME, System.currentTimeMillis());
        map.put(PaymentConstants.REF_NUMBER, refNo); // set UUID
    }
}
