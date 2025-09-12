package com.system.management.library.aplikasi.book.management.service.managementuser.impl;

import com.system.management.library.aplikasi.book.management.mapper.managementuser.UserMapper;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserRepository;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void update(RegisterRequestRecord request) {

        validasiMandatory(request);
        var userExisting = userRepository.findById(request.id()).orElseThrow(() -> new RuntimeException("Data user tidak ditemukan"));

        // validasi data existing
        if (userRepository.existsByEmailAndIdNot(request.email().toLowerCase(), request.id())) {
            throw new RuntimeException("Email [" + request.email() + "] sudah digunakan");
        }
        if (userRepository.existsByUsernameAndIdNot(request.username().toLowerCase(), request.id())) {
            throw new RuntimeException("Username [" + request.username() + "] sudah digunakan");
        }

        var user = userMapper.requestToEntity(request);
        user.setId(userExisting.getId());
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
            throw new RuntimeException("Email tidak boleh kosong");
        }
        if (request.role() == null) {
            throw new RuntimeException("Role tidak boleh kosong");
        }
    }
}

