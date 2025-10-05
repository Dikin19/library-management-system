package com.system.management.library.aplikasi.book.management.entity.transaction;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.system.management.library.aplikasi.book.management.entity.app.BaseEntity;
import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_loan", indexes = {
        @Index(name = "idx_loan_created_date", columnList = "createdDate"),
        @Index(name = "idx_loan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_loan_tanggalPinjam", columnList = "tanggalPinjam"),
        @Index(name = "idx_loan_tanggalKembali", columnList = "tanggalKembali"),
        @Index(name = "idx_loan_status", columnList = "status"),
        @Index(name = "idx_loan_user_id", columnList = "user_id"),
        @Index(name = "idx_loan_book_id", columnList = "book_id")

})
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private LocalDateTime tanggalPinjam;

    private LocalDateTime tanggalKembali;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = true)
    private Long denda;


    // Many-to-One dengan User (Loan/peminjamann bisa dilakukan berkali" oleh 1 User)
    // user_id adalah foreign key yang menunjuk ke tabel user memlalui variable member
    // kolom user_id mendapatkan user.id dari user untuk pembuatan setiap satu user/member memijam buku.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
//    @JsonBackReference("user-loan")
    private User user;


    // Many-to-One dengan Book (Loan/peminjaman bisa meminjam bekali" untuk 1 Book yang sama)
    // book_id adalah foreign key yang menunjuk ke tabel Book melalui variable book
    // kolom book_id mendapatkan idbook dari table book untuk pembuatan setiap peminjaman melalui idbook
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
//    @JsonBackReference("book-loan")
    private Book book;
}

