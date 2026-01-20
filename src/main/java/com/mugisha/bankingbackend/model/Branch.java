package com.mugisha.bankingbackend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String branchCode;
    private String branchName;
    private String address;

    // ONE Branch to MANY Accounts
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    // ONE Branch to MANY Employees
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    // ================= Getters and Setters =================
    public Long getBranchId() { return branchId; }
    public void setBranchId(Long branchId) { this.branchId = branchId; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<Account> getAccounts() { return accounts; }
    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
