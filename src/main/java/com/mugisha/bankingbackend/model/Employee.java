package com.mugisha.bankingbackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role; // TELLER, MANAGER, ADMIN, SUPPORT
    private LocalDate hireDate;
    private String status; // ACTIVE, INACTIVE, SUSPENDED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL)
    private List<Transaction> approvedTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL)
    private List<Loan> approvedLoans = new ArrayList<>();

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    private List<SupportTicket> assignedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<AuditLog> auditLogs = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ================= Getters and Setters =================
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }

    public List<Transaction> getApprovedTransactions() { return approvedTransactions; }
    public void setApprovedTransactions(List<Transaction> approvedTransactions) { this.approvedTransactions = approvedTransactions; }

    public List<Loan> getApprovedLoans() { return approvedLoans; }
    public void setApprovedLoans(List<Loan> approvedLoans) { this.approvedLoans = approvedLoans; }

    public List<SupportTicket> getAssignedTickets() { return assignedTickets; }
    public void setAssignedTickets(List<SupportTicket> assignedTickets) { this.assignedTickets = assignedTickets; }

    public List<AuditLog> getAuditLogs() { return auditLogs; }
    public void setAuditLogs(List<AuditLog> auditLogs) { this.auditLogs = auditLogs; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
