package com.system.management.library.aplikasi.book.management.controller.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestResponse;
import com.system.management.library.aplikasi.book.management.service.transaction.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/pinjam-buku")
    public ResponseEntity<LoanRequestResponse> pinjamBuku(@RequestBody LoanRequestRecord request) {
        Loan loan = loanService.pinjamBuku(request);
        return ResponseEntity.ok(LoanRequestResponse.fromEntity(loan));
    }

}
