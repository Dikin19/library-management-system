package com.system.management.library.aplikasi.book.management.controller.managementuser;


import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Tag(name = "Create Profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("create")
    public BaseResponse<?> create(@RequestBody UserProfileRequestRecord request){

        userProfileService.create(request);
        return BaseResponse.ok("Data berhasil ditambahkan", null);
    }


}
