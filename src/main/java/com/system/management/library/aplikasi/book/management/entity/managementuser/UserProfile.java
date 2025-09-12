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
@Table(name = "m_user", indexes = {
        @Index(name = "idx_user_created_date", columnList = "createdDate"),
        @Index(name = "idx_user_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_user_fullname", columnList = "fullname"),
        @Index(name = "idx_user_phoneNumber", columnList = "phoneNumber"),
        @Index(name = "idx_user_address", columnList = "address"),
        @Index(name = "idx_user_status", columnList = "status"),

})
public class UserProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // kolom user_id mendapatkan user.id dari user untuk pebuatan setiap satu profile satu user.
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
