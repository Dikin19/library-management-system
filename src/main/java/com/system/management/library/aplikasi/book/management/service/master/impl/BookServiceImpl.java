package com.system.management.library.aplikasi.book.management.service.master.impl;

import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.master.Category;
import com.system.management.library.aplikasi.book.management.mapper.master.BookMapper;
import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.master.BookRepository;
import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import com.system.management.library.aplikasi.book.management.service.master.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ValidatorService validatorService;
    private final BookMapper bookMapper;

    @Override
    public void add(BookRequestRecord request) {

            validatorService.validator(request);

            var book = bookMapper.requestToEntity(request);
            bookRepository.save(book);
    }

    @Override
    public List<SimpleMap> getAllBooks() {
        List<Book> listBook = bookRepository.findAll();

        return listBook.stream().map(book -> {
            SimpleMap data = new SimpleMap();
            data.add("id", book.getId());
            data.add("title", book.getTitle());
            data.add("author", book.getAuthor());
            data.add("stock", book.getStock());

            List<String> categoryNames = book.getCategories()
                    .stream()
                    .map(Category::getName)
                    .toList();
            data.add("categories", categoryNames);

            return data;
        }).collect(Collectors.toList());
    }

    @Override
    public SimpleMap findById(String id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data book tidak ditemukan"));

        SimpleMap data = new SimpleMap();
        data.put("id", book.getId());
        data.put("title", book.getTitle());
        data.put("author", book.getAuthor());
        data.put("stock", book.getStock());

        List<String> categoryNames = book.getCategories()
                .stream()
                .map(Category::getName)
                .toList();
        data.add("categories", categoryNames);

        return data;
    }

    public void update(BookRequestRecord request) {

        var bookExisting = bookRepository.findById(request.id()).orElseThrow(() -> new RuntimeException("Data user tidak ditemukan"));

        if (bookRepository.existsByAuthorAndIdNot(request.author().toLowerCase(), request.id())) {
            throw new RuntimeException("Author [" + request.author() + "] sudah digunakan");
        }
        if (bookRepository.existsByTitleAndIdNot(request.title().toLowerCase(), request.id())) {
            throw new RuntimeException("Title [" + request.title() + "] sudah digunakan");
        }

        var book = bookMapper.requestToEntity(request);
        book.setId(bookExisting.getId());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id){
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("buku dengan ID " +id+ "tidak ditemukan"));
        bookRepository.delete(book);
    }




}
