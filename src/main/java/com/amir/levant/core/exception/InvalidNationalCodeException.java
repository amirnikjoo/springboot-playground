package com.amir.levant.core.exception;

public class InvalidNationalCodeException extends IException {

    public InvalidNationalCodeException(Long refNo, Integer sourceId) {
        super(refNo, sourceId);
    }
}