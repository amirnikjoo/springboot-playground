package com.amir.levant.service;


import com.amir.levant.dto.ParameterDto;
import com.amir.levant.model.Parameter;
import com.amir.levant.repository.ParameterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParameterServiceImpl implements ParameterService {
    private final ParameterRepository parameterRepository;
    private final ModelMapper modelMapper;

    @Override
    public ParameterDto getParameterById(Long id) {
        Optional<Parameter> parameter = parameterRepository.findById(id);
        return parameter.map(value -> modelMapper.map(value, ParameterDto.class)).orElse(null);
    }

    @Override
    public List<ParameterDto> getParameterByGroupId(Integer groupId) {
        List<Parameter> byGroupId = parameterRepository.findByGroupId(groupId);
        List<ParameterDto> dtos = byGroupId.stream()
                .map(user -> modelMapper.map(user, ParameterDto.class))
                .collect(Collectors.toList());

        return dtos;

    }

    @Override
    public Parameter getParameterByGroupIdAndClue(Integer groupId, String clue) {
        Parameter parameter = parameterRepository.findByGroupIdAndClue(groupId, clue);
        return parameter;
    }

    @Override
    @Transactional
    public ParameterDto add(ParameterDto dto) {
        return null;
    }

    private Parameter prepareParameter(ParameterDto dto) {
        Parameter parameter = new Parameter();
        parameter.setGroupId(dto.getGroupId());
        parameter.setGroupName(dto.getGroupName());
        parameter.setGroupNameDesc(dto.getGroupNameDesc());
        parameter.setClue(dto.getClue());
        parameter.setValue(dto.getValue());
        parameter.setCreateDate(new Date());
        parameter.setLastEditDate(new Date());
        return parameter;
    }

}
