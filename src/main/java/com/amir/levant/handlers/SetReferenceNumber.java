package com.amir.levant.handlers;

import com.amir.levant.core.Constants;
import com.amir.levant.core.IHandler;
import com.amir.levant.util.MyUtility;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class SetReferenceNumber extends IHandler {
//    private final ParameterService parameterService;

    @Override
    public void process(Map map) throws Exception {
        String refNo = MyUtility.generateRefNo1();
        log.info("---- inside ---- {} ", refNo);

//        ParameterDto parameterById = parameterService.getParameterById(1L);
        map.put(Constants.REF_NO, refNo); // set UUID
        throw new Exception("test");
    }
}
