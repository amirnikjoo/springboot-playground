package com.kian.card.handlers;

import com.kian.card.core.Constants;
import com.kian.card.core.IHandler;
import com.kian.card.service.ParameterService;
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
