package com.system.management.library.aplikasi.book.management.repository.managementuser;

import com.system.management.library.aplikasi.book.management.entity.managementuser.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserProfileRepository extends JpaRepository<UserProfile, String>, JpaSpecificationExecutor<UserProfile> {

    Boolean existsByFullnameAndIdNot(String fullname, String id);
    Boolean existsByPhoneAndIdNot(String phone, String id);
}
