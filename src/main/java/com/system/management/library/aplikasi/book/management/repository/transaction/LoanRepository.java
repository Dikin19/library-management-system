package com.system.management.library.aplikasi.book.management.repository.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoanRepository extends JpaRepository<Loan, String>, JpaSpecificationExecutor<Loan> {



}
