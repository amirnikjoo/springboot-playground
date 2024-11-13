package com.kian.card.core.exception;

public class ChannelException extends IException {

    public ChannelException(Long refNo, Integer sourceId) {
        super(refNo, sourceId);
    }
}