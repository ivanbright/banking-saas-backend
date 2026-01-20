package com.mugisha.bankingbackend.utils;
public enum AccountType {
    SAVINGS("10"),
    CURRENT("20"),
    FIXED("30");

    private final String code;

    AccountType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
