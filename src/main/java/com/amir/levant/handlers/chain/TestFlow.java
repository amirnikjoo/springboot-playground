package com.amir.levant.handlers.chain;

import com.amir.levant.core.IHandler;

import java.util.Map;


//@Component
public class TestFlow extends IHandler {

    @Override
    public void process(Map map) throws Exception {
        processChainHandler(map);
    }
}
