package com.amir.levant.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonDto {

    @NotNull
    private String name;

}
