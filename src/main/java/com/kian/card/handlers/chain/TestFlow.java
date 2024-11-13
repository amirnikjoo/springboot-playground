package com.kian.card.handlers.chain;

import com.kian.card.core.IHandler;

import java.util.Map;


//@Component
public class TestFlow extends IHandler {

    @Override
    public void process(Map map) throws Exception {
        processChainHandler(map);
    }
}
