package com.amir.levant.resource;

import com.amir.levant.dto.ResponseDto;
import com.amir.levant.dto.TransactionDto;
import com.amir.levant.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/v1/payment")
//@RequiredArgsConstructor
@Slf4j
public class PaymentResource {
    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
        log.info("PaymentResource is created...");

    }

    @PostMapping("/do")
    public ResponseEntity<Void> doPayment(@RequestBody TransactionDto transactionDto) {
//        log.info("do payment {}", transactionDto);
        transactionDto.setInsertDate(new Date());
        paymentService.doPayment(transactionDto);
        return ResponseEntity.ok().build();
    }
}
