package com.amir.levant.core;

import com.amir.levant.core.exception.IException;
import com.amir.levant.dto.ResponseDto;
import com.amir.levant.model.Parameter;
import com.amir.levant.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    final
    ParameterRepository parameterRepository;

    public GlobalExceptionHandler(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @ExceptionHandler(IException.class)
    public ResponseEntity<ResponseDto> handleAllExceptions(IException ex) {
        log.error("message: {}, simpleName: {}", ex.getMessage(), ex.getClass().getSimpleName());
        Parameter paraException = parameterRepository.findByGroupIdAndClue(2000, ex.getClass().getSimpleName());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setRefNo(ex.getRefNo());
        responseDto.setResDesc(ex.getMessage());
        responseDto.setResCode(paraException.getValue());
        responseDto.setReqDate(new Date());
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
