package com.system.management.library.aplikasi.book.management.service.transaction.impl;

import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.transaction.Loan;
import com.system.management.library.aplikasi.book.management.mapper.transaction.LoanMapper;
import com.system.management.library.aplikasi.book.management.model.enums.Status;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.LoanRequestResponse;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserRepository;
import com.system.management.library.aplikasi.book.management.repository.master.BookRepository;
import com.system.management.library.aplikasi.book.management.repository.transaction.LoanRepository;
import com.system.management.library.aplikasi.book.management.service.transaction.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanMapper loanMapper;

    @Override
    public Loan pinjamBuku(LoanRequestRecord request){

        User user = userRepository.findById(request.userId()).
                orElseThrow(()-> new RuntimeException("user tidak ditemukan"));

        Book book = bookRepository.findById(request.bookId()).
                orElseThrow(()-> new RuntimeException("buku tidak ditemukan"));

        Loan loan = loanMapper.requestToEntity(request, user, book);

        return loanRepository.save(loan);
    }

    @Override
    public Loan kembalikanBuku(String loanId){

        Loan loan = loanRepository.findById(loanId).
                orElseThrow(()-> new RuntimeException("Data peminjaman tidak ditemukan"));

        if (loan.getStatus() == Status.RETURNED){
            throw new RuntimeException("Buku sudah dikembalikan");
        }

        loan.setTanggalKembali(LocalDateTime.now());
        loan.setStatus(Status.RETURNED);

        LocalDateTime batasTanggalKembaliBuku = loan.getTanggalPinjam().plusDays(7);
        if (loan.getTanggalKembali().isAfter(batasTanggalKembaliBuku)){
            long hariTerlambat = java.time.Duration
                    .between(batasTanggalKembaliBuku, loan.getTanggalKembali())
                    .toDays();
            long denda = hariTerlambat * 1000;
            System.out.println("total denda keterlambatan " +hariTerlambat+ " * " + "1000");
            loan.setDenda(denda);
        }

        return loanRepository.save(loan);

    }

    @Override
    public List<LoanRequestResponse> getAllLoans(){
        List<Loan> loans = loanRepository.findAll();

        return loans.stream().map(LoanRequestResponse::fromEntity).toList();
    }




}
