package com.system.management.library.aplikasi.book.management.model.enums;

import lombok.Getter;

@Getter
public enum Role {

    ADMIN("Admin"),
    MEMBER("Member");


    private final String label;

    Role(String label) {
        this.label = label;
    }

}
