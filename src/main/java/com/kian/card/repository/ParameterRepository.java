package com.kian.card.repository;

import com.kian.card.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    Parameter findByGroupIdAndClue(Integer groupId, String clue);

    List<Parameter> findByGroupId(Integer groupId);

    @Query(value = "SELECT CARD_REF_NO_SEQ.nextval from dual", nativeQuery = true)
    Long generateRefNo();

}
