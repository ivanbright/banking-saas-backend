package com.mugisha.bankingbackend.utils;

import com.mugisha.bankingbackend.model.Branch;
import com.mugisha.bankingbackend.repository.AccountSequenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountNumberGenerator {

    private static  final String BANK_CODE ="250";

    @Transactional
    public String generateAccountNumber(
            Branch branch,
            AccountSequenceRepository repo,
            AccountType accountType) {


        AccountSequence seq = repo.findById(branch.getBranchId())
                .orElseGet(()->{
                    AccountSequence s = new AccountSequence();
                    s.setBranchId(branch.getBranchId());
                    s.setNextValue(1L);
                    return s;
                });

        long current = seq.getNextValue();
        seq.setNextValue(current+1);
        repo.save(seq);

        return BANK_CODE +
                branch.getBranchCode() +
                accountType.getCode() +
                String.format("%08d", current);
    }


}
