package com.system.management.library.aplikasi.book.management.entity.master;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore // Prevent infinite loop during JSON serialization
    private List<Loan> loans = new ArrayList<>();

    // Many_to-Many dengan book dan category.
    // book bisa mempunya banyak category dan category mempunyai banyak book
    // kita menggunakan joinTable untuk memmbuat table penghubung yang dinamakan book_category
    // joinColumns menentukan fk untuk entity saat ini yaitu book dan kita buat nama fk nya book_id
    // inverseJoinColumns menentukan entity lawan yaitu category dan kita buat category_id
    // kita buat list dari table Category dan variable categories
    // untuk mappedBy categories di table category
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"), // FK ke Book
            inverseJoinColumns = @JoinColumn(name = "category_id") // FK ke Category
    )
    @Builder.Default
    private List<Category> categories = new ArrayList<>();

}


