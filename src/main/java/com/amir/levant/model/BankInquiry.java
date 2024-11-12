package com.amir.levant.model;

import com.amir.levant.enums.BankInquiryStatus;
import com.amir.levant.enums.Banks;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "BANK_INQUIRY")
public class BankInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_bank_inquiry_seq")
    @SequenceGenerator(name = "card_bank_inquiry_seq", sequenceName = "CARD_BANK_INQUIRY_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String bank;

    @Column(nullable = false, length = 128)
    private String requestId;

    @Column(nullable = false, length = 12)
    private String nationalCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BankInquiryStatus status;

}
