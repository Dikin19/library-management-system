package com.system.management.library.aplikasi.book.management.entity.master;

import com.system.management.library.aplikasi.book.management.entity.app.BaseEntity;
import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_book", indexes = {
        @Index(name = "idx_book_created_date", columnList = "createdDate"),
        @Index(name = "idx_book_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_book_title", columnList = "title"),
        @Index(name = "idx_book_author", columnList = "author"),
        @Index(name = "idx_book_stock", columnList = "stock"),

})
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = true)
    private Integer stock;


    // One-to-many dengan Loan adalah one book bisa dipinjam berkali" dan akan di record dalam tabel loan atau dipinjam
    // book untuk menandakan dan mengisi value primaryKey book_id yang berada di table loan/peminjaman untuk relasi one-to-many ini.
    // maapedBy = "book" harus sama dengan variable yang dibuat didalam table Loan.
    // book menjadi one-to-many di table Loan ditandai dengan private List<Loan> loans.
    // List<Loan> untuk menampung one book yang dipinjam berkali".
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true,  fetch = FetchType.LAZY)
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();


}


