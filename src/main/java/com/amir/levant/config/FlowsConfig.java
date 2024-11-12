package com.amir.levant.config;

import com.amir.levant.core.IHandler;
import com.amir.levant.handlers.SetReferenceNumber;
import com.amir.levant.handlers.chain.TestFlow;
import com.amir.levant.handlers.jobs.BankInquiryFlow;
import com.amir.levant.handlers.jobs.BankInquiryPrepareRequest;
import com.amir.levant.handlers.jobs.BankInquiryResponseProcess;
import com.amir.levant.handlers.jobs.CallBank;
import com.amir.levant.handlers.test.ExceptionHandler1;
import com.amir.levant.handlers.test.Handler1;
import com.amir.levant.repository.BankInquiryRepository;
import com.amir.levant.service.ParameterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class FlowsConfig {

    @Bean
    public IHandler testChainHandler() {
        TestFlow flow = new TestFlow();
        flow.setHandlers(Arrays.asList(new Handler1()));
        flow.setExceptionHandler(Arrays.asList(new ExceptionHandler1()));
        return flow;
    }

    @Bean
    public IHandler bankInquiryChainHandler(ParameterService parameterService, BankInquiryRepository bankInquiryRepository) {
        BankInquiryFlow flow = new BankInquiryFlow();
        flow.setHandlers(Arrays.asList(
                new SetReferenceNumber(parameterService),
                new BankInquiryPrepareRequest(),
                new CallBank(),
                new BankInquiryResponseProcess(bankInquiryRepository)
        ));


        flow.setExceptionHandler(Arrays.asList(new ExceptionHandler1()));
        return flow;
    }
}

