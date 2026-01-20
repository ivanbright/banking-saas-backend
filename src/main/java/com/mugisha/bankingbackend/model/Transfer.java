package com.mugisha.bankingbackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;

    private BigDecimal amount;
    private String status;
    private LocalDateTime initiatedAt;

    // MANY Transfers to ONE Sender Account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    // MANY Transfers to ONE Receiver Account (can be null for external)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    // MANY Transfers to ONE Beneficiary
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;

    // ONE Transfer to TWO Transactions (debit and credit)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_transaction_id")
    private Transaction debitTransaction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_transaction_id")
    private Transaction creditTransaction;

    // =============== Getters and Setters =================
    public Long getTransferId() {
        return transferId;
    }
    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getInitiatedAt() {
        return initiatedAt;
    }
    public void setInitiatedAt(LocalDateTime initiatedAt) {
        this.initiatedAt = initiatedAt;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }
    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }
    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }
    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Transaction getDebitTransaction() {
        return debitTransaction;
    }
    public void setDebitTransaction(Transaction debitTransaction) {
        this.debitTransaction = debitTransaction;
    }

    public Transaction getCreditTransaction() {
        return creditTransaction;
    }
    public void setCreditTransaction(Transaction creditTransaction) {
        this.creditTransaction = creditTransaction;
    }
}
