package com.system.management.library.aplikasi.book.management.model.request;

import com.system.management.library.aplikasi.book.management.model.enums.Role;

public record RegisterRequestRecord(
        String id,
        String username,
        String email,
        String password,
        Role role
) {
}
