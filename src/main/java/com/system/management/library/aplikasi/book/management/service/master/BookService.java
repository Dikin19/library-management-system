package com.system.management.library.aplikasi.book.management.service.master;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;

import java.util.List;

public interface BookService {

    void add(BookRequestRecord request);

    List<SimpleMap> getAllBooks();

    SimpleMap findById(String id);

    void update(BookRequestRecord request);

    void deleteBook(String id);

}
