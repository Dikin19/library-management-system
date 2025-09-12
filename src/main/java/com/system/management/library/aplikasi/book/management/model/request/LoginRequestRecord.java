package com.system.management.library.aplikasi.book.management.model.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestRecord(@NotBlank String username,
                                 @NotBlank String password) {
}
