package com.system.management.library.aplikasi.book.management.entity.managementuser;


import com.system.management.library.aplikasi.book.management.entity.app.BaseEntity;
import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_user", indexes = {
        @Index(name = "idx_user_created_date", columnList = "createdDate"),
        @Index(name = "idx_user_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_user_username", columnList = "username"),
        @Index(name = "idx_user_password", columnList = "password"),
        @Index(name = "idx_user_role", columnList = "role")

})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // One-to-One dengan UserProfile adalah setiap user hanya mempunyai satu userProfile
    // user adalah untuk menandakan dan mengisi value primaryKey user_id yang berada di table userProfile untuk relasi one-to-one ini.
    // maapedBy = "user" harus sama dengan variable yang dibuat didalam table userProfie.
    // user menjadi one-to-one di UserProfile ditandai akses dengan private UserProfile profile;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true,  fetch = FetchType.LAZY)
    private UserProfile profile;

    // One-to-many dengan Loan adalah 1 member/user bisa meminjam banyak buku dan akan di record dalam tabel loan atau peminjaman
    // member untuk menandakan dan mengisi value primaryKey user_id yang berada di table loan/peminjaman untuk relasi one-to-many ini.
    // maapedBy = "member" harus sama dengan variable yang dibuat didalam table Loan.
    // member menjadi one-to-many di table Loan ditandai dengan private List<Loan> loans.
    // List<Loan> untuk menampung 1 user/member yang mempunyai banyak record peminjaman.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member", orphanRemoval = true,  fetch = FetchType.LAZY)
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    private String token;

    private LocalDateTime expiredTokenAt;


}
