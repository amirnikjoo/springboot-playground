package com.amir.levant.config;

import com.amir.levant.core.IHandler;
import com.amir.levant.handlers.chain.RegisterFlow;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeans {
    public IHandler flowHandler(){
        return new RegisterFlow();
    }

}
