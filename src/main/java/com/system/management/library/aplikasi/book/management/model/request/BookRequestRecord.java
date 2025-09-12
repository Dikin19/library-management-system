package com.system.management.library.aplikasi.book.management.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BookRequestRecord(
        String id,
        @NotBlank(message = "Title tidak boleh kosong") String title,
        @NotBlank(message = "Author tidak boleh kosong")String author,
        @NotNull(message = "Stok tidak boleh kosong") Integer stock,
        List<String> categoryIds ) {
}
