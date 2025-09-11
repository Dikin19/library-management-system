package com.system.management.library.aplikasi.book.management.model.enums;

import lombok.Getter;

@Getter
public enum Status {

    STUDENT_ACTIVE("Mahasiswa Aktif"),
    GRADUATED("Alumni");

    private final String label;

    Status(String label) {
        this.label = label;
    }

}
