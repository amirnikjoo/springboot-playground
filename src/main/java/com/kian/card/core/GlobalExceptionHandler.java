package com.kian.card.core;

import com.kian.card.core.exception.IException;
import com.kian.card.dto.ResponseDto;
import com.kian.card.model.Parameter;
import com.kian.card.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.Random;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    final
    ParameterRepository parameterRepository;

    public GlobalExceptionHandler(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleAllExceptions(Exception ex) {
        log.error("message: {}, simpleName: {}", ex.getMessage(), ex.getClass().getSimpleName());
        ResponseDto responseDto = new ResponseDto();
        Parameter paraException = parameterRepository.findByGroupIdAndClue(2000, ex.getClass().getSimpleName());
        if (ex instanceof IException) {
            responseDto.setRefNo(((IException) ex).getRefNo());
        } else {
            responseDto.setRefNo(new Random(100000000L).nextLong());
        }
        responseDto.setResDescFa(paraException.getDescFa());
        responseDto.setResDescEn(paraException.getDescEn());
        responseDto.setResCode(paraException.getValue());
        responseDto.setReqDate(new Date());
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
