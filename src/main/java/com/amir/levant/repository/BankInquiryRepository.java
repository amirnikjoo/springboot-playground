package com.amir.levant.repository;

import com.amir.levant.enums.BankInquiryStatus;
import com.amir.levant.model.BankInquiry;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BankInquiryRepository extends JpaRepository<BankInquiry, Long> {

    default List<BankInquiry> findTop1ByStatus(BankInquiryStatus status) {
        Pageable pageable = PageRequest.of(0, 1);
        return findByStatus(status, pageable);
    }

    List<BankInquiry> findByStatus(BankInquiryStatus status, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update BANK_INQUIRY bi set bi.status= :status where bi.id=:id")
    void updateBankInquiriesByStatus(Long id, BankInquiryStatus status);

}
