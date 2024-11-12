package com.amir.levant.core.exception;

public class DataAccessException extends IException {


    public DataAccessException(Long refNo, Integer sourceId) {
        super(refNo, sourceId);
    }
}