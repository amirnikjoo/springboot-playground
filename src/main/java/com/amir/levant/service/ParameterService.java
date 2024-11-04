package com.amir.levant.service;


import com.amir.levant.dto.ParameterDto;
import com.amir.levant.model.Parameter;


public interface ParameterService {

    Parameter getParameterById(String refNo, Long id);

//    List<ParameterDto> getParameterByGroupId(String refNo, Integer groupId);

//    Parameter getParameterByGroupIdAndClue(String refNo, Integer groupId, String clue);

//    ParameterDto add(String refNo, ParameterDto dto);

}
