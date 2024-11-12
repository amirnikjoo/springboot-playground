package com.amir.levant.service;

import com.amir.levant.core.Constants;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class BankInquiryServiceImpl implements BankInquiryService {
    private final BankInquiryRepository bankInquiryRepository;
    private final ParameterRepository parameterRepository;

    @Override
    @Transactional
    public ResponseDto doRegister(BankInquiryDto dto) throws Exception {
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

        ResponseDto responseDto = Constants.SUCCESS_RESPONSE_DTO;
        responseDto.setRefNo(refNo);
        return responseDto;
    }

    @Override
    public List<BankInquiry> getBankInquiries(BankInquiryStatus status) {
        return bankInquiryRepository.findTop1ByStatus(BankInquiryStatus.CREATED);
    }
}
