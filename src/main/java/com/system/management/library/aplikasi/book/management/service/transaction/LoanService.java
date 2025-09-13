package com.system.management.library.aplikasi.book.management.service.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;

public interface LoanService {

    Loan pinjamBuku(LoanRequestRecord request);

}
