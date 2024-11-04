package com.amir.levant.handlers;

import com.amir.levant.constants.PaymentConstants;
import com.amir.levant.core.IHandler;
import com.amir.levant.dto.ParameterDto;
import com.amir.levant.model.Parameter;
import com.amir.levant.repository.ParameterRepository;
import com.amir.levant.service.ParameterService;
import com.amir.levant.util.MyUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.util.Map;

//@Bean
//@AllArgsConstructor
@Slf4j
public class SetReferenceNumber extends IHandler {
    private ParameterService parameterService;
    private Long paramGroupId;

    public Long getParamGroupId() {
        return paramGroupId;
    }

    public void setParamGroupId(Long paramGroupId) {
        this.paramGroupId = paramGroupId;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @Override
    public void process(Map map) throws Exception {
        map.put(PaymentConstants.REQUEST_TIME, System.currentTimeMillis());
        String refNo = MyUtility.generateRefNo1();
        log.info("---- inside ---- {} ", refNo);

        Parameter parameterById = parameterService.getParameterById(refNo, paramGroupId);
        log.info("---- parameter 1 ---- {} ", parameterById);
        map.put(PaymentConstants.START_TIME, System.currentTimeMillis());
        map.put(PaymentConstants.REF_NUMBER, refNo); // set UUID
    }
}
