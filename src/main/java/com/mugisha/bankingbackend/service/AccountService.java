package com.mugisha.bankingbackend.service;

import com.mugisha.bankingbackend.model.*;
import com.mugisha.bankingbackend.repository.AccountRepository;
import com.mugisha.bankingbackend.repository.AccountSequenceRepository;
import com.mugisha.bankingbackend.repository.BranchRepository;
import com.mugisha.bankingbackend.utils.AccountNumberGenerator;
import com.mugisha.bankingbackend.utils.AccountStatus;
import com.mugisha.bankingbackend.utils.AccountType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountNumberGenerator accountNumberGenerator;
    private BranchRepository branchRepository;
    private AccountRepository accountRepository;
    private AccountSequenceRepository accountSequenceRepository;
    public AccountService(AccountRepository accountRepository, AccountNumberGenerator accountNumberGenerator) {
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    @Transactional
    public Account createAccount(Long branchId, AccountType type) {

        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        String accountNumber = accountNumberGenerator.generateAccountNumber(
                branch,
                accountSequenceRepository,
                type
        );

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBranch(branch);
        account.setAccountType(type);
        account.setCurrentBalance(BigDecimal.ZERO);
        account.setStatus(AccountStatus.ACTIVE);

        return accountRepository.save(account);
    }

    public Account updateAccount (Account account) {
        return accountRepository.save(account);
    }
    public  Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
    }
    public List<Account> getAccountsByUserId(Long id) {
        return accountRepository.findAccountsByUserId(id);
    }
}
