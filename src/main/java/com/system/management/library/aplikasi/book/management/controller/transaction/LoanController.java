package com.system.management.library.aplikasi.book.management.controller.transaction;

import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.mapper.transaction.LoanMapper;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.LoanResponse;
import com.system.management.library.aplikasi.book.management.service.transaction.LoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
@Tag(name = "Manage Loans")
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    // buat response dari LoanRequestResnponse untuk menampkan data sesuai yang kita mau terhadap relasi table.
    // ambil data client dari request body
    // kirim data ke loanservice setelah logic selesai lalu dikembalikan ke controller.
    // data loan terbaru masuk ke loanRequestResponse yang sudah dibuat dan di tampilkan utuk client.
    @PostMapping("/pinjam-buku")
    public ResponseEntity<LoanResponse> pinjamBuku(@RequestBody LoanRequestRecord request) {
        Loan loan = loanService.pinjamBuku(request);
        return ResponseEntity.ok(loanMapper.toResponse(loan));
    }

    @PostMapping("/kembalikan-buku/{loanId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LoanResponse> kembalikanBuku(@PathVariable String loanId){
        Loan loan = loanService.kembalikanBuku(loanId);
                return ResponseEntity.ok(loanMapper.toResponse(loan));
    }

    @GetMapping("/find-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LoanResponse>> getAllLoans(){
        List<LoanResponse> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

}
