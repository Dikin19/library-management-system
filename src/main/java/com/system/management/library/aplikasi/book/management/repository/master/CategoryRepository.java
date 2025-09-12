package com.system.management.library.aplikasi.book.management.repository.master;

import com.system.management.library.aplikasi.book.management.entity.master.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {


}
