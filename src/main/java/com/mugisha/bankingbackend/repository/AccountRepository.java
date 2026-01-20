package com.mugisha.bankingbackend.repository;

import com.mugisha.bankingbackend.model.Account;
import com.mugisha.bankingbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountId(Long accountId);
    List<Account> findAccountsByUserId(Long id);
}
