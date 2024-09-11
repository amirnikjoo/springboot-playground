package com.amir.levant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private Long refId;
    private String resCode;
    private Date reqDate;

}
