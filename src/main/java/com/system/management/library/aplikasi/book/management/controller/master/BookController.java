package com.system.management.library.aplikasi.book.management.controller.master;


import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.BookRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.master.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Tag(name = "Book API")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<?> save(@RequestBody BookRequestRecord request) {
        bookService.add(request);
        return BaseResponse.ok("Data berhasil disimpan", null);
    }

    @GetMapping("/find-all")
    public BaseResponse<List<SimpleMap>> getAllUsers() {
        List<SimpleMap> books = bookService.getAllBooks();
        return BaseResponse.ok("Data berhasil ditampikan", books);
    }

    @GetMapping("/find-by-id/{id}")
    public BaseResponse<?> findById(@PathVariable String id) {
        return BaseResponse.ok(null, bookService.findById(id));

    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<?> update(@RequestBody BookRequestRecord request) {
        bookService.update(request);
        return BaseResponse.ok("Data berhasil diubah", null);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<Void> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return BaseResponse.ok("Buku berhasil dihapus", null);
    }


}
