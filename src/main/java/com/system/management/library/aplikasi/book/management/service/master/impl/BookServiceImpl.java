package com.system.management.library.aplikasi.book.management.service.master.impl;

import com.system.management.library.aplikasi.book.management.mapper.master.BookMapper;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.master.BookRepository;
import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import com.system.management.library.aplikasi.book.management.service.master.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
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




}
