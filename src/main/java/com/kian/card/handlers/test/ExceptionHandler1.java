package com.kian.card.handlers.test;

import com.kian.card.core.IHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ExceptionHandler1 extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        log.info("----inside ExceptionHandler1 ----");
    }
}
