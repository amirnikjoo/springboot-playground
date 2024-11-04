package com.amir.levant.service;


import com.amir.levant.core.IHandler;
import com.amir.levant.dto.ParameterDto;
import com.amir.levant.model.Parameter;
import com.amir.levant.repository.ParameterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
public class ParameterServiceImpl extends IHandler implements ParameterService {
    private final ParameterRepository parameterRepository;
//    private final ModelMapper modelMapper;


    @Override
    public Parameter getParameterById(String refNo, Long id) {
        log.info("---- called  getParameterById---- {}", refNo);
        Optional<Parameter> parameter = parameterRepository.findById(id);
        return parameter.orElse(null);
//        return parameter.map(value -> modelMapper.map(value, ParameterDto.class)).orElse(null);
    }

/*
    @Override
    public List<ParameterDto> getParameterByGroupId(String refNo, Integer groupId) {
        log.info("---- called  getParameterByGroupId---- {}, {} ", refNo, Thread.currentThread().getName());
//        List<Parameter> byGroupId = parameterRepository.findByGroupId(groupId);
//        List<ParameterDto> dtos = byGroupId.stream()
//                .map(user -> modelMapper.map(user, ParameterDto.class))
//                .collect(Collectors.toList());

//        return dtos;
        return null;
    }

    @Override
    public Parameter getParameterByGroupIdAndClue(String refNo, Integer groupId, String clue) {
        log.info("---- called  getParameterByGroupIdAndClue---- {}, {} ", refNo, Thread.currentThread().getName());
        Parameter parameter = parameterRepository.findByGroupIdAndClue(groupId, clue);
        return parameter;
    }

    @Override
    @Transactional
    public ParameterDto add(String refNo, ParameterDto dto) {
        return null;
    }
*/

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

    @Override
    public void process(Map map) throws Exception {

    }
}
