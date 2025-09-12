package com.system.management.library.aplikasi.book.management.entity.master;

import com.system.management.library.aplikasi.book.management.entity.app.BaseEntity;
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
@Table(name = "m_category", indexes = {
        @Index(name = "idx_category_created_date", columnList = "createdDate"),
        @Index(name = "idx_category_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_category_name", columnList = "name")

})
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    // Many-to-Many dengan book variable categories harus sama dengan variable list category di table book
    // books menyimpang category book yang dibuatkan dalam table penghubung book_category.
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Book> books = new ArrayList<>();
}


