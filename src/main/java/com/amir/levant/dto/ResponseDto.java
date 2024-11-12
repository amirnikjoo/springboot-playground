package com.amir.levant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private Long refNo;
    private String resCode;
    private String resDescFa;
    private String resDescEn;
    private Date reqDate;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(Long refNo, String resCode, String resDescFa, String resDescEn, Date reqDate, Object data) {
        this.refNo = refNo;
        this.resCode = resCode;
        this.resDescFa = resDescFa;
        this.resDescEn = resDescEn;
        this.reqDate = reqDate;
        this.data = data;
    }

    public ResponseDto(Long refNo, String resCode, String resDescFa, String resDescEn, Date reqDate) {
        this.refNo = refNo;
        this.resCode = resCode;
        this.resDescFa = resDescFa;
        this.resDescEn = resDescEn;
        this.reqDate = reqDate;
    }
}
