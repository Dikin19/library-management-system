package com.system.management.library.aplikasi.book.management;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.enums.Role;
import com.system.management.library.aplikasi.book.management.model.request.LoginRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.service.app.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void registerUserTest() {
        RegisterRequestRecord request = new RegisterRequestRecord(
                null,
                "dikin19",
                "dikin19@mail.com",
                "123456",
                Role.ADMIN
        );
        authService.register(request);
        System.out.println("User berhasil diregistrasi");
    }

    @Test
    void loginUserTest() {
        LoginRequestRecord loginRequest = new LoginRequestRecord(
                "dikin",
                "123456"
        );
        SimpleMap result = authService.login(loginRequest);
        System.out.println("Token login: " + result.get("token"));
    }
}
