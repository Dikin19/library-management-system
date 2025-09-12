package com.system.management.library.aplikasi.book.management;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.enums.Role;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetAllUsers() {
        List<SimpleMap> users = userService.getAllUsers();
        System.out.println("Jumlah user: " + users.size());
        for (SimpleMap u : users) {
            System.out.println(u);
        }
    }

    @Test
    void testFindById() {
        String id = "bff570e7-3e14-4070-b657-2c0de694ec37";
        SimpleMap user = userService.findById(id);
        System.out.println("User dengan ID " + id + ": " + user);
    }

    @Test
    void testUpdateUser() {
        String id = "bff570e7-3e14-4070-b657-2c0de694ec37";

        RegisterRequestRecord request = new RegisterRequestRecord(
                id,
                "UpdatedUsername",
                "updated@email.com",
                "updatedPassword",
                Role.ADMIN
        );

        userService.update(request);
        System.out.println("User berhasil diupdate");
    }

    @Test
    void testDeleteUser() {
        String id = "bff570e7-3e14-4070-b657-2c0de694ec37";
        userService.deleteUser(id);
        System.out.println("User dengan ID " + id + " berhasil dihapus");
    }
}
