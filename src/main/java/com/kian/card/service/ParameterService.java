package com.kian.card.service;


import com.kian.card.dto.ParameterDto;
import com.kian.card.model.Parameter;

import java.util.List;

public interface ParameterService {

    ParameterDto getParameterById(Long id);

    List<ParameterDto> getParameterByGroupId(Integer groupId);

    Parameter getParameterByGroupIdAndClue(Integer groupId, String clue);

    ParameterDto add(ParameterDto dto);

    Long generateRefNo();

}
