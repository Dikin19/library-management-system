package com.system.management.library.aplikasi.book.management.mapper.transaction;


import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    // kita ambil entity dari variable relasi ke table Book dan User
    // melalui param yang kita buat untuk mapper.

    public Loan requestToEntity(LoanRequestRecord request, User member, Book book){
        return Loan.builder()
                .tanggalPinjam(request.tanggalPinjam())
                .tanggalKembali(request.tanggalKembali())
                .status(request.status())
                .member(member)
                .book(book).build();
    }
}
