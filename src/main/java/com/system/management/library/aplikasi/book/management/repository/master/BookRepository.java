package com.system.management.library.aplikasi.book.management.repository.master;

import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book> {

    Boolean existsByAuthorAndIdNot(String author, String id);
    Boolean existsByTitleAndIdNot(String title, String id);

}
