package com.system.management.library.aplikasi.book.management;

import com.system.management.library.aplikasi.book.management.entity.managementuser.UserProfile;
import com.system.management.library.aplikasi.book.management.model.enums.Role;
import com.system.management.library.aplikasi.book.management.model.enums.Status;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserServiceProfileTests {

    @Autowired
    private UserProfileService userProfileService;

    @Test
    void testCreateUserProfile() {
        var request = new UserProfileRequestRecord(
                null,
                "John Doe1",
                "081234567890",
                "Jakarta",
                Status.BORROWED,
                Role.MEMBER,
                UUID.randomUUID().toString()
        );

        userProfileService.create(request);
        System.out.println("UserProfile berhasil dibuat: " + request.fullname());
    }

    @Test
    void testFindById() {
        String id = "c4bdbddd-f547-4b4a-afb1-e28af938f5a6";
        var profile = userProfileService.findById(id);
        System.out.println("UserProfile ditemukan: " + profile);
    }

    @Test
    void testUpdateUserProfile() {
        String id = "c4bdbddd-f547-4b4a-afb1-e28af938f5a6";

        var request = new UserProfileRequestRecord(
                id,
                "Updated Name",
                "08999999999",
                "Bandung",
                Status.RETURNED,
                Role.ADMIN,
                "user-123"
        );

        userProfileService.update(request);
        System.out.println("UserProfile berhasil diupdate: " + request.fullname());
    }

    @Test
    void testDeleteUserProfile() {
        String id = "c4bdbddd-f547-4b4a-afb1-e28af938f5a6";
        userProfileService.deleteProfile(id);
        System.out.println("UserProfile dengan ID " + id + " berhasil dihapus");
    }
}
