package com.bankloanapplication.model;

import com.bankloanapplication.model.entity.Loan;

public enum LoanStatus {
    ACTIVE, INACTIVE;
    public static LoanStatus get(int index){
        return LoanStatus.values()[index];
    }
}
