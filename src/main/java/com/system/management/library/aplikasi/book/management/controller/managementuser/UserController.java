package com.system.management.library.aplikasi.book.management.controller.managementuser;

import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("update")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<?> edit(@RequestBody RegisterRequestRecord request) {
        userService.update(request);
        return BaseResponse.ok("Data berhasil diubah", null);
    }

}
