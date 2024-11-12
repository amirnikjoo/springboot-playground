package com.amir.levant.service;

import com.amir.levant.core.Constants;
import com.amir.levant.core.exception.DataAccessException;
import com.amir.levant.core.exception.InvalidNationalCodeException;
import com.amir.levant.dto.BankInquiryDto;
import com.amir.levant.dto.ResponseDto;
import com.amir.levant.enums.BankInquiryStatus;
import com.amir.levant.model.BankInquiry;
import com.amir.levant.repository.BankInquiryRepository;
import com.amir.levant.repository.ParameterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.Date;


@Slf4j
@Service
@AllArgsConstructor
public class BankInquiryServiceImpl implements BankInquiryService {
    private final BankInquiryRepository bankInquiryRepository;
    private final ParameterRepository parameterRepository;

    @Override
    @Transactional
    public void doRegister(BankInquiryDto dto) throws Exception {
        Long refNo = parameterRepository.generateRefNo();
        log.info("doRegister refNo: {}", refNo);

        if (dto.getNationalCode().length() > 10){
            throw new InvalidNationalCodeException(refNo, Constants.EXCEPTION_SOURCE_ID_CARD_CHANNEL);
        }

        BankInquiry bankInquiry = new BankInquiry();
        bankInquiry.setBank(dto.getBankName());
        bankInquiry.setStatus(BankInquiryStatus.CREATED);
        bankInquiry.setNationalCode(dto.getNationalCode());
        bankInquiry.setRequestId(dto.getRequestId());
        bankInquiryRepository.save(bankInquiry);

    }
}
