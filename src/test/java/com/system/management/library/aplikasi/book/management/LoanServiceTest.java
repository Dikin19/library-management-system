package com.system.management.library.aplikasi.book.management;

import com.system.management.library.aplikasi.book.management.model.enums.Status;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestResponse;
import com.system.management.library.aplikasi.book.management.service.transaction.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @Test
    void testPinjamBuku() {
        var request = new LoanRequestRecord(
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(7),
                Status.BORROWED,
                0L,
                "d8aed052-59fc-453c-a37b-a301c0cae33c",
                "d0c54712-0c7a-40be-80ef-02ccf05ccd69"
        );

        var loan = loanService.pinjamBuku(request);
        System.out.println("Buku berhasil dipinjam: " + loan.getId() +
                ", Status: " + loan.getStatus());
    }

    @Test
    void testKembalikanBuku() {
        var request = new LoanRequestRecord(
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(7),
                Status.BORROWED,
                0L,
                "d8aed052-59fc-453c-a37b-a301c0cae33c",
                "d0c54712-0c7a-40be-80ef-02ccf05ccd69"
        );
        var loan = loanService.pinjamBuku(request);

        var returnedLoan = loanService.kembalikanBuku(loan.getId());
        System.out.println("✅ Buku berhasil dikembalikan: " + returnedLoan.getId() +
                ", Status: " + returnedLoan.getStatus() +
                ", Denda: " + returnedLoan.getDenda());
    }

    @Test
    void testGetAllLoans() {
        List<LoanRequestResponse> loans = loanService.getAllLoans();
        System.out.println("Jumlah peminjaman: " + loans.size());
        for (LoanRequestResponse l : loans) {
            System.out.println(l);
        }
    }
}
