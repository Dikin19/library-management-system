package com.system.management.library.aplikasi.book.management.model.request;

import com.system.management.library.aplikasi.book.management.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LoanRequestRecord (

        @NotNull(message = "Tanggal peminjaman tidak boleh kosong")LocalDateTime tanggalPinjam,
        LocalDateTime tanggalKembali,
        @NotNull(message = "Status tidak boleh kosong")Status status,
        long denda,
        @NotBlank(message = "UserId tidak boleh kosong") String userId,
        @NotBlank(message = "BookId tidak boleh kosong")String bookId
)
{

}
