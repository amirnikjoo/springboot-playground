package com.amir.levant.service;

import com.amir.levant.dto.ResponseDto;
import com.amir.levant.dto.TransactionDto;

public interface PaymentService {
    ResponseDto doPayment(TransactionDto transactionDto);


}
