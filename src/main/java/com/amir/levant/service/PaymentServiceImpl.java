package com.amir.levant.service;

import com.amir.levant.dto.ResponseDto;
import com.amir.levant.dto.TransactionDto;
import com.amir.levant.model.Transaction;
import com.amir.levant.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService{
    private final TransactionRepository transactionRepository;

    private final ModelMapper modelMapper;

    public PaymentServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
//        log.info("PaymentServiceImpl is created...");
    }

    @Override
//    @Transactional
    public ResponseDto doPayment(TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transactionRepository.save(transaction);
        return new ResponseDto();
    }
}
