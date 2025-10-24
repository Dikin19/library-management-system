package com.system.management.library.aplikasi.book.management.model.response;

import com.system.management.library.aplikasi.book.management.model.enums.Status;

import java.time.LocalDateTime;

// untuk dipake dalam loanResponse dalam mapper
public record LoanResponse(
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
}
