package com.system.management.library.aplikasi.book.management;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;
import com.system.management.library.aplikasi.book.management.service.master.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testAddBook() {
        var request = new BookRequestRecord(
                null,
                "Clean Code " + UUID.randomUUID(),
                "Robert C. Martin",
                10,
                List.of("Programming", "IT")
        );

        bookService.add(request);
        System.out.println("Buku berhasil ditambahkan: " + request.title());
    }

    @Test
    void testGetAllBooks() {
        List<SimpleMap> books = bookService.getAllBooks();
        System.out.println("Jumlah buku: " + books.size());
        for (SimpleMap book : books) {
            System.out.println(book);
        }
    }
}
