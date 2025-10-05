package com.system.management.library.aplikasi.book.management.service.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.LoanResponse;

import java.util.List;

public interface LoanService {

    // buat method pinjam buku untuk menjadi jembatan antara service dan controller
    // setelah client memberi data, data akan di olah kedalam logic service dan dikembalikan lagi ke controller.
    Loan pinjamBuku(LoanRequestRecord request);

    Loan kembalikanBuku(String loanId);

    List<LoanResponse> getAllLoans();

}
