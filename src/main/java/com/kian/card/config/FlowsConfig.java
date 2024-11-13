package com.kian.card.config;

import com.kian.card.core.IHandler;
import com.kian.card.handlers.SetReferenceNumber;
import com.kian.card.handlers.chain.TestFlow;
import com.kian.card.handlers.jobs.BankInquiryFlow;
import com.kian.card.handlers.jobs.BankInquiryPrepareRequest;
import com.kian.card.handlers.jobs.BankInquiryResponseProcess;
import com.kian.card.handlers.jobs.CallBank;
import com.kian.card.handlers.test.ExceptionHandler1;
import com.kian.card.handlers.test.Handler1;
import com.kian.card.repository.BankInquiryRepository;
import com.kian.card.service.ParameterService;
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

