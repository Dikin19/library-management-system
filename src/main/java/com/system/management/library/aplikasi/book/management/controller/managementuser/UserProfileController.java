package com.system.management.library.aplikasi.book.management.controller.managementuser;


import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Tag(name = "Manage Profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody UserProfileRequestRecord request){

        userProfileService.create(request);
        return BaseResponse.ok("Profile berhasil ditambahkan", null);
    }

    @PostMapping("/update")
    public BaseResponse<?> update(@RequestBody UserProfileRequestRecord request){
        userProfileService.update(request);
        return BaseResponse.ok("Profile berhasil di update", null);
    }

    @GetMapping("/find-all")
    public BaseResponse<List<SimpleMap>> getAllProfiles() {
        List<SimpleMap> profiles = userProfileService.getAllProfiles();
        return BaseResponse.ok("Data berhasil ditampikan", profiles);
    }

    @GetMapping("/find-by-id/{id}")
    public BaseResponse<?> findById(@PathVariable String id) {
        return BaseResponse.ok(null, userProfileService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<Void> deleteProfile(@PathVariable String id){
        userProfileService.deleteProfile(id);
        return BaseResponse.ok("Profile berhasil dihapus", null);
    }




}
