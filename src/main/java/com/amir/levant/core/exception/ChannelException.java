package com.amir.levant.core.exception;

public class ChannelException extends IException {

    public ChannelException(Long refNo, Integer sourceId) {
        super(refNo, sourceId);
    }
}