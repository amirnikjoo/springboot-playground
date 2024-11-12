package com.amir.levant.core.exception;

import com.amir.levant.dto.ResponseDto;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class IException extends Exception {
    static final long serialVersionUID = -334147822944743062L;
    Long refNo;
    Integer sourceId;
    String myMessage = "";
    ResponseDto responseDto = new ResponseDto();

    public IException(Long refNo, Integer sourceId) {

        this.refNo = refNo;
        this.sourceId = sourceId;
    }

}
