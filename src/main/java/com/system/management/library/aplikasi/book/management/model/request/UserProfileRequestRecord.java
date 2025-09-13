package com.system.management.library.aplikasi.book.management.model.request;

import com.system.management.library.aplikasi.book.management.model.enums.Role;
import com.system.management.library.aplikasi.book.management.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserProfileRequestRecord(

        @NotBlank(message = "Fullname tidak boleh kosong") String fullname,
        @NotBlank(message = "Nomor telephone tidak boleh kosong") String phone,
        @NotBlank(message = "Alamat tidak boleh kosong") String address,
        @NotNull(message = "Status tidak boleh kosong")Status status,
        @NotNull(message = "Role tidak boleh kosong")Role role,
        @NotNull(message = "UserId tidak boleh kosong") String userId


        ) {
}
