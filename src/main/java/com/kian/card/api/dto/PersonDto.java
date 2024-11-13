package com.kian.card.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PersonDto {

    @NotNull
    private String name;

}
