package com.system.management.library.aplikasi.book.management.model.request;


import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.enums.Status;

import java.time.LocalDateTime;

public record LoanRequestResponse(
        String loanId,
        String userId,
        String username,
        String bookId,
        String bookTitle,
        LocalDateTime tanggalPinjam,
        LocalDateTime tanggalKembali,
        Status status,
        long denda
) {
    public static LoanRequestResponse fromEntity(Loan loan) {
        return new LoanRequestResponse(
                loan.getId(),
                loan.getMember().getId(),
                loan.getMember().getUsername(),
                loan.getBook().getId(),
                loan.getBook().getTitle(),
                loan.getTanggalPinjam(),
                loan.getTanggalKembali(),
                loan.getStatus(),
                loan.getDenda() != null ? loan.getDenda() : 0
        );
    }
}
