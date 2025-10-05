package com.system.management.library.aplikasi.book.management.mapper.transaction;


import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.LoanResponse;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    // kita ambil entity dari variable relasi ke table Book dan User
    // melalui param yang kita buat untuk mapper lalu kembalikan data ke service.
    // maaper untuk request
    public Loan requestToEntity(LoanRequestRecord request, User user, Book book){
        return Loan.builder()
                .tanggalPinjam(request.tanggalPinjam())
                .tanggalKembali(request.tanggalKembali())
                .status(request.status())
                .denda(request.denda())
                .user(user)
                .book(book).build();
    }

    public LoanResponse toResponse(Loan loan){
        return new LoanResponse(
                loan.getId(),
                loan.getUser().getId(),
                loan.getUser().getUsername(),
                loan.getBook().getId(),
                loan.getBook().getTitle(),
                loan.getTanggalPinjam(),
                loan.getTanggalKembali(),
                loan.getStatus(),
                loan.getDenda() != null ? loan.getDenda() : 0

        );
    }
}
