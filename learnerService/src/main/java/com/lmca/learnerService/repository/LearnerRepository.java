package com.lmca.learnerService.repository;

import com.lmca.learnerService.model.Learner;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Long> {
    boolean existsByEmailId(String emailId);
}

