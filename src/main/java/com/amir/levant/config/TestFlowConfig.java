package com.amir.levant.config;

import com.amir.levant.core.IHandler;
import com.amir.levant.handlers.SetReferenceNumber;
import com.amir.levant.handlers.chain.TestFlow;
import com.amir.levant.handlers.test.ExceptionHandler1;
import com.amir.levant.handlers.test.Handler1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestFlowConfig {

    @Bean
    public IHandler testChainHandler() {
        TestFlow mainHandler = new TestFlow();
        mainHandler.setHandlers(Arrays.asList(new Handler1(), new SetReferenceNumber()));
        mainHandler.setExceptionHandler(Arrays.asList(new ExceptionHandler1()));
        return mainHandler;
    }
}

