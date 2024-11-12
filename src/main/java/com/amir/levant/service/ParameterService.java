package com.amir.levant.service;


import com.amir.levant.dto.ParameterDto;
import com.amir.levant.model.Parameter;

import java.util.List;

public interface ParameterService {

    ParameterDto getParameterById(Long id);

    List<ParameterDto> getParameterByGroupId(Integer groupId);

    Parameter getParameterByGroupIdAndClue(Integer groupId, String clue);

    ParameterDto add(ParameterDto dto);

    Long generateRefNo();

}
