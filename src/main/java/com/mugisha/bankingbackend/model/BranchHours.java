package com.mugisha.bankingbackend.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "branch_hours")
public class BranchHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hoursId;

    private String dayOfWeek; // MONDAY, TUESDAY, etc.
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Boolean isHoliday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    // ================= Getters and Setters =================
    public Long getHoursId() { return hoursId; }
    public void setHoursId(Long hoursId) { this.hoursId = hoursId; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public LocalTime getOpeningTime() { return openingTime; }
    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }

    public LocalTime getClosingTime() { return closingTime; }
    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }

    public Boolean getIsHoliday() { return isHoliday; }
    public void setIsHoliday(Boolean isHoliday) { this.isHoliday = isHoliday; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}
