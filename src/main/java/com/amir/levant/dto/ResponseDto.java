package com.amir.levant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private Long refNo;
    private String resCode;
    private String resDesc;
    private Date reqDate;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(Long refNo, String resCode, String resDesc, Date reqDate, Object data) {
        this.refNo = refNo;
        this.resCode = resCode;
        this.resDesc = resDesc;
        this.reqDate = reqDate;
        this.data = data;
    }
}
