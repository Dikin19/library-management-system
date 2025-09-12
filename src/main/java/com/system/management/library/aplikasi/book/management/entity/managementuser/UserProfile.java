package com.system.management.library.aplikasi.book.management.entity.managementuser;


import com.system.management.library.aplikasi.book.management.entity.app.BaseEntity;
import com.system.management.library.aplikasi.book.management.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_user_profile", indexes = {
        @Index(name = "idx_user_profile_created_date", columnList = "createdDate"),
        @Index(name = "idx_user_profile_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_user_profile_fullname", columnList = "fullname"),
        @Index(name = "idx_user_profile_phone", columnList = "phone"),
        @Index(name = "idx_user_profile_address", columnList = "address"),
        @Index(name = "idx_user_profile_status", columnList = "status"),
        @Index(name = "idx_user_profile_user_id", columnList = "user_id"),

})
public class UserProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // One-to-One dengan User (1 user hanya memiliki 1 profile)
    // user_id adalah foreign key yang menunjuk ke tabel user memlalui variable user
    // kolom user_id mendapatkan user.id dari user untuk pembuatan setiap satu profile satu user.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
