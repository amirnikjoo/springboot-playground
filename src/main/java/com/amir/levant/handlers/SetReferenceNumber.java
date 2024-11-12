package com.amir.levant.handlers;

import com.amir.levant.core.Constants;
import com.amir.levant.core.IHandler;
import com.amir.levant.service.ParameterService;
import com.amir.levant.util.MyUtility;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class SetReferenceNumber extends IHandler {
    private final ParameterService parameterService;

    @Override
    public void process(Map map) throws Exception {
        Long refNo = parameterService.generateRefNo();
        log.info("---- inside ---- {} ", refNo);

        map.put(Constants.REF_NO, refNo);
    }

}
