package com.kian.card.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {
    Long id;
    Long refId;
    Long orgRefId;
    ServiceId serviceId;
    Long pan;
    Long pan2;
    Long amount;
    String localDate;
    String localTime;
    String iban;
    String BillId;
    String paymentId;
    String payerId;

    int channelId;
    String channelType;

    int terminalId;
    String stan;
    String rrn;

    String additionalData;

    String resCode;
    String exceptionMessage;
    int duration;
    Date insertDate;
}
