package com.system.management.library.aplikasi.book.management.service.managementuser;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;

import java.util.List;

public interface UserProfileService {

    void create(UserProfileRequestRecord request);

    void update(UserProfileRequestRecord request);

    List<SimpleMap> getAllProfiles();

    SimpleMap findById(String Id);

    void deleteProfile(String id);
}
