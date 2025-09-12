package com.system.management.library.aplikasi.book.management.controller.app;

import com.system.management.library.aplikasi.book.management.config.UserLoggedInConfig;
import com.system.management.library.aplikasi.book.management.model.request.LoginRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.app.AuthService;
import com.system.management.library.aplikasi.book.management.service.app.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginRequestRecord request) {
        return BaseResponse.ok(null, authService.login(request));
    }

    @GetMapping("/logout")
    public BaseResponse<?> logout(@AuthenticationPrincipal UserLoggedInConfig userLogout){
        var userLoggedIn =userLogout.getUser();
        authService.logout(userLoggedIn);
        return BaseResponse.ok("Berhasil logout", null);
    }


}
