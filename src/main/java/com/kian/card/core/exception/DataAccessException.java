package com.kian.card.core.exception;

public class DataAccessException extends IException {


    public DataAccessException(Long refNo, Integer sourceId) {
        super(refNo, sourceId);
    }
}