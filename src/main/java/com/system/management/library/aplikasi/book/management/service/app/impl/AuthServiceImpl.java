package com.system.management.library.aplikasi.book.management.service.app.impl;


import com.system.management.library.aplikasi.book.management.mapper.managementuser.UserMapper;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserRepository;
import com.system.management.library.aplikasi.book.management.service.app.AuthService;
import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import com.system.management.library.aplikasi.book.management.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ValidatorService validatorService;
    private final UserMapper userMapper;


    @Override
    public void register(RegisterRequestRecord request) {

        // validasi mandatory
        validasiMandatory(request);

        // validasi data existing
        if (userRepository.existsByEmail(request.email().toLowerCase())) {
            throw new RuntimeException("Email [" + request.email() + "] sudah digunakan");
        }
        if (userRepository.existsByUsername(request.username().toLowerCase())) {
            throw new RuntimeException("Username [" + request.username() + "] sudah digunakan");
        }

        var user = userMapper.requestToEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }


    private void validasiMandatory(RegisterRequestRecord request) {

        if (request.username() == null || request.username().isEmpty()) {
            throw new RuntimeException("Username tidak boleh kosong");
        }
        if (request.email() == null || request.email().isEmpty()) {
            throw new RuntimeException("Email tidak boleh kosong");
        }
        if (request.password() == null || request.password().isEmpty()) {
            throw new RuntimeException("Password tidak boleh kosong");
        }
        if (request.role() == null) {
            throw new RuntimeException("Role tidak boleh kosong");
        }
    }


}

