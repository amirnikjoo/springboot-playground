package com.kian.card.service;

import com.kian.card.dto.ResponseDto;
import com.kian.card.dto.TransactionDto;

public interface PaymentService {
    ResponseDto doPayment(TransactionDto transactionDto);


}
