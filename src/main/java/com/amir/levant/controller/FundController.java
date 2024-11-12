package com.amir.levant.controller;

import com.amir.levant.api.dto.PersonDto;
import com.amir.levant.core.Constants;
import com.amir.levant.core.IHandler;
import com.amir.levant.dto.TransactionDto;
import com.amir.levant.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/payment")
//@RequiredArgsConstructor
@Slf4j
public class FundController {
    private final PaymentService paymentService;

    //    private final IHandler registerFlow;
//    private final IHandler testFlow;
    @Autowired
    private IHandler testChainHandler;

    public FundController(PaymentService paymentService) {
        this.paymentService = paymentService;
//        this.registerFlow = registerFlow;
//        this.testFlow = testFlow;
        log.info("PaymentResource is created...");

    }

    @PostMapping("/do")
    public ResponseEntity<Void> doPayment(@RequestBody TransactionDto transactionDto) {
//        log.info("do payment {}", transactionDto);
        transactionDto.setInsertDate(new Date());
        paymentService.doPayment(transactionDto);
        return ResponseEntity.ok().build();
    }

/*
    @PostMapping("/register")
    public ResponseEntity<String > register(@RequestBody PersonDto inputDto,
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
*/

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody PersonDto inputDto,
                                       @RequestHeader Map<String, String> headers) {

        log.info("request_body: {} ", inputDto.toString());
        Map map = new HashMap();
        map.put(Constants.REQUEST_OBJECT, inputDto);
        map.put(Constants.REQUEST_HEADERS, headers);

        try {
            testChainHandler.process(map);
        } catch (Exception e) {
            log.error(e.getMessage());
//            result = e.getMessage() + "|" + e.toString();
        }

        String refNo = (String) map.get(Constants.REF_NO);
        return refNo != null ? ResponseEntity.ok(refNo) : ResponseEntity.badRequest().build();
    }

}
