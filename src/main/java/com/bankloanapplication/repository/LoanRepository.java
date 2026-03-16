package com.bankloanapplication.repository;

import com.bankloanapplication.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {


}
