package com.amir.levant.repository;

import com.amir.levant.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    Parameter findByGroupIdAndClue(Integer groupId, String clue);

    List<Parameter> findByGroupId(Integer groupId);

}
