package com.system.management.library.aplikasi.book.management.controller.app;

import com.system.management.library.aplikasi.book.management.model.request.LoginRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.app.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public BaseResponse<?> register(@RequestBody RegisterRequestRecord request) {
        authService.register(request);
        return BaseResponse.ok("Data berhasil disimpan", null);
    }

    @PostMapping("login")
    public BaseResponse<?> login(@RequestBody LoginRequestRecord request) {
        return BaseResponse.ok(null, authService.login(request));
    }


}
