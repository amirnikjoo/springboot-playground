package com.amir.levant.controller;

import com.amir.levant.api.dto.PersonDto;
import com.amir.levant.constants.PaymentConstants;
import com.amir.levant.core.IHandler;
import com.amir.levant.dto.TransactionDto;
import com.amir.levant.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/payment")
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;
    private final IHandler registerFlow;

    public PaymentController(PaymentService paymentService, @Qualifier("registerFlow") IHandler registerFlow) {
        this.paymentService = paymentService;
        this.registerFlow = registerFlow;
        log.info("PaymentResource is created...");

    }

    @PostMapping("/do")
    public ResponseEntity<Void> doPayment(@RequestBody TransactionDto transactionDto) {
//        log.info("do payment {}", transactionDto);
        transactionDto.setInsertDate(new Date());
        paymentService.doPayment(transactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PersonDto inputDto,
                                           @RequestHeader Map<String, String> headers) {

        log.info("request_body: {} ", inputDto.toString());
        Map map = new HashMap();
        map.put(PaymentConstants.REQUEST_OBJECT, inputDto);
        map.put(PaymentConstants.HEADERS, headers);

        try {
            registerFlow.process(map);
        } catch (Exception e) {
            log.error(e.getMessage());
//            result = e.getMessage() + "|" + e.toString();
        }

        String refNo = (String) map.get(PaymentConstants.REF_NUMBER);
        return refNo != null ? ResponseEntity.ok(refNo) : ResponseEntity.badRequest().build();
    }

}
