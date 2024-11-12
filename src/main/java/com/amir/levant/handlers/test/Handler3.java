package com.amir.levant.handlers.test;

import com.amir.levant.core.IHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Handler3 extends IHandler {
    @Override
    public void process(Map map) throws Exception {
        log.info("----inside Handler3 ----");
    }
}
