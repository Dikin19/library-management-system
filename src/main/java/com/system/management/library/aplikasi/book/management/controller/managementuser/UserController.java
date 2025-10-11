package com.system.management.library.aplikasi.book.management.controller.managementuser;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
@Tag(name = "Manage Users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<?> edit(@RequestBody RegisterRequestRecord request) {
        userService.update(request);
        return BaseResponse.ok("Data berhasil diubah", null);
    }

    @GetMapping("/find-all")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<List<SimpleMap>> getAllUsers(){
        List<SimpleMap> users = userService.getAllUsers();
        return BaseResponse.ok("Data berhasil ditampikan", users);
    }

    @GetMapping("/find-by-id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<?> findById(@PathVariable String id){
    return BaseResponse.ok(null, userService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<Void> deleteBook(@PathVariable String id){
        userService.deleteUser(id);
        return BaseResponse.ok("User berhasil dihapus", null);
    }

}
