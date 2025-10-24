package com.system.management.library.aplikasi.book.management.service.app.impl;

import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {
    // | Kondisi                                                        | Butuh ValidatorServiceImpl? | Penjelasan                                  |
    //| -------------------------------------------------------------- | --------------------------- | ------------------------------------------- |
    //| Validasi otomatis di Controller pakai `@Valid`                 | ❌ Tidak perlu               | Spring Boot sudah tangani otomatis          |
    //| Mau validasi manual di Service layer                           | ✅ Perlu                     | Supaya bisa dipanggil di tempat lain        |
    //| Mau validasi data dari sumber non-request (CSV, API lain, dll) | ✅ Perlu                     | Karena `@Valid` hanya berlaku di Controller |
    //| Mau format error custom                                        | ✅ Perlu                     | Bisa ubah isi pesan error sesuai kebutuhan  |
    private final Validator validator;

    @Override
    public void validator(Object request) {

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

}

