package com.system.management.library.aplikasi.book.management.mapper.master;

import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.master.Category;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.master.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    private final CategoryRepository categoryRepository ;
    public BookMapper(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Book requestToEntity(BookRequestRecord request) {
        List<Category> categories = categoryRepository.findAllById(request.categoryIds());

        return Book.builder()
                .title(request.title().toLowerCase())
                .author(request.author().toLowerCase())
                .stock(request.stock())
                .categories(categories)
                .build();
    }

}
