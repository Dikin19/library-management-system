package com.system.management.library.aplikasi.book.management.mapper.managementuser;

import com.system.management.library.aplikasi.book.management.entity.managementuser.UserProfile;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

    public UserProfile requestToEntity(UserProfileRequestRecord request){

        return UserProfile.builder()
                .fullname(request.fullname().toUpperCase())
                .phone(request.phone())
                .address(request.address())
                .status(request.status())
                .role(request.role())
                .build();

    }

}
