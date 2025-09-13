package com.system.management.library.aplikasi.book.management.service.managementuser;

import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;

public interface UserProfileService {

    void create(UserProfileRequestRecord request);

    void update(UserProfileRequestRecord request);

}
