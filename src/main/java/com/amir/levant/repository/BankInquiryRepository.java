package com.amir.levant.repository;

import com.amir.levant.model.BankInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankInquiryRepository extends JpaRepository<BankInquiry, Long> {
}
