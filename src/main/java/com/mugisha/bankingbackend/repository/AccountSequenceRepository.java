package com.mugisha.bankingbackend.repository;

import com.mugisha.bankingbackend.utils.AccountSequence;
import com.mugisha.bankingbackend.utils.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountSequenceRepository extends JpaRepository <AccountSequence, Long> {
    Optional<AccountSequence> findByBranchIdAndAccountType(Long branchId, AccountType accountType);
}
