package com.system.management.library.aplikasi.book.management.service.managementuser.impl;

import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.mapper.managementuser.UserMapper;
import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserRepository;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
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

    @Override
    public List<SimpleMap> getAllUsers(){
        List<User> listUser = userRepository.findAll();

        return listUser.stream().map(user -> {
            SimpleMap data = new SimpleMap();
                data.add("id", user.getId());
                data.add("username", user.getUsername());
                data.add("email", user.getEmail());
                data.add("role", user.getRole());

                return data;

        }).collect(Collectors.toList());


    }

    @Override
    public SimpleMap findById(String id) {
        var user = userRepository.findById(id).orElseThrow(
                () ->  new RuntimeException("Data user tidak ditemukan"));
        SimpleMap data = new SimpleMap();
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("email", user.getEmail());
        data.put("role", user.getRole().getLabel());
        return data;

    }

    @Override
    public void deleteUser(String id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user dengan ID " +id+ "tidak ditemukan"));
        userRepository.delete(user);
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

