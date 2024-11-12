/*
package com.amir.levant.component;

import com.amir.levant.core.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegisterFlow {
    private final IHandler registerFlowHandler;

    @Autowired
    public RegisterFlow(@Qualifier("registerFlow") IHandler registerFlowHandler) {
        this.registerFlowHandler = registerFlowHandler;
    }

    public void execute(Map<String, Object> data) {
        try {
            registerFlowHandler.processChainHandler(data);
        } catch (Exception e) {
            // Handle exception
        }
    }
}
*/
