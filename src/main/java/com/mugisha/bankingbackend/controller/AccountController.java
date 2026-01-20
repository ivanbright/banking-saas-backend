package com.mugisha.bankingbackend.controller;

import com.mugisha.bankingbackend.model.Account;
import com.mugisha.bankingbackend.model.User;
import com.mugisha.bankingbackend.service.AccountService;
import com.mugisha.bankingbackend.utils.CreateAccountRequest;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable Long id) {
        Object account  = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountByUser(@PathVariable Long userId) {
        List<Account> account = accountService.getAccountsByUserId(userId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountRequest accountRequest) {
        Account createdAccount = accountService.createAccount(accountRequest.getBranchId(), accountRequest.getAccountType());
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
}
