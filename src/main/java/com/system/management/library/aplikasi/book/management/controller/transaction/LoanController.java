package com.system.management.library.aplikasi.book.management.controller.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestResponse;
import com.system.management.library.aplikasi.book.management.service.transaction.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
@Tag(name = "Manage Loans")
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/pinjam-buku")
    public ResponseEntity<LoanRequestResponse> pinjamBuku(@RequestBody LoanRequestRecord request) {
        Loan loan = loanService.pinjamBuku(request);
        return ResponseEntity.ok(LoanRequestResponse.fromEntity(loan));
    }

    @PostMapping("/kembalikan-buku/{loanId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LoanRequestResponse> kembalikanBuku(@PathVariable String loanId){
        Loan loan = loanService.kembalikanBuku(loanId);
                return ResponseEntity.ok(LoanRequestResponse.fromEntity(loan));
    }

    @GetMapping("/find-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LoanRequestResponse>> getAllLoans(){
        List<LoanRequestResponse> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

}
