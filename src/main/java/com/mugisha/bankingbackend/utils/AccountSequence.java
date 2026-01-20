package com.mugisha.bankingbackend.utils;

import jakarta.persistence.*;

@Entity
@Table(name="account_sequences")
public class AccountSequence {
    @Id
    private Long branchId;
    private Long nextValue;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getNextValue() {
        return nextValue;
    }

    public void setNextValue(Long nextValue) {
        this.nextValue = nextValue;
    }
}
