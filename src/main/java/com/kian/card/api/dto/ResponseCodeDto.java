package com.kian.card.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCodeDto {

    String responseCode;

    String description;

}