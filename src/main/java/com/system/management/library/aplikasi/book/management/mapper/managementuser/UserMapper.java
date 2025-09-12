package com.system.management.library.aplikasi.book.management.mapper.managementuser;


import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User requestToEntity(RegisterRequestRecord request) {
        return User.builder()
                .username(request.username().toLowerCase())
                .email(request.email().toLowerCase())
                .password(request.password())
                .role(request.role())
                .build();
    }

}
