package com.amir.levant.model;

import com.amir.levant.dto.ServiceId;
import javax.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@Slf4j
public class Transaction {
    public Transaction() {
        log.info("Transaction is created...");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_transaction_gen")
    @SequenceGenerator(name = "table_transaction_gen", sequenceName = "TABLE_TRANSACTION_ID_SEQUENCE", allocationSize = 1)
    private Long id;

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
