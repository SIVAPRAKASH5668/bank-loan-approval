package com.bankloanapplication.repository;

import com.bankloanapplication.model.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Long> {
}
