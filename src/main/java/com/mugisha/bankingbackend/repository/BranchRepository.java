package com.mugisha.bankingbackend.repository;

import com.mugisha.bankingbackend.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findById(Long id);

}
