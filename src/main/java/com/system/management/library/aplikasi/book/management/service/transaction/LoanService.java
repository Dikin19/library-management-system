package com.system.management.library.aplikasi.book.management.service.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestResponse;

import java.util.List;

public interface LoanService {

    Loan pinjamBuku(LoanRequestRecord request);

    Loan kembalikanBuku(String loanId);

    List<LoanRequestResponse> getAllLoans();

}
