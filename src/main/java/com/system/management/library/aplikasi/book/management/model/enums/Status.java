package com.system.management.library.aplikasi.book.management.model.enums;

import lombok.Getter;

@Getter
public enum Status {

    // cara menampilkan di di FE
    // status.name() (BORROWED)
    // status.getLabel() (Sedang dipinjam).
    // Dan untuk didatabase data yang akan tersimpan adalah BORROWED

    BORROWED("Sedang dipinjam"),
    RETURNED("Sudah dikembalikan");

    private final String label;

    Status(String label) {
        this.label = label;
    }

}
