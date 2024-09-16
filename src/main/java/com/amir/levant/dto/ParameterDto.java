package com.amir.levant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParameterDto {
    private Long id;
    private Integer groupId;
    private String groupName;
    private String groupNameDesc;
    private String clue;
    private String value;
    private Date createDate;
    private Date lastEditDate;
}