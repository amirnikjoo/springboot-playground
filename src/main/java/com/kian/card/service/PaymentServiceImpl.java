package com.kian.card.service;

import com.kian.card.dto.ResponseDto;
import com.kian.card.dto.TransactionDto;
import com.kian.card.model.Transaction;
import com.kian.card.repository.TransactionRepository;
import javax.transaction.Transactional;

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
        log.info("PaymentServiceImpl is created...");
    }

    @Override
    @Transactional
    public ResponseDto doPayment(TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transactionRepository.save(transaction);
        return new ResponseDto();
    }
}
