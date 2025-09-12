package com.system.management.library.aplikasi.book.management.service.managementuser;

import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;

import java.util.List;

public interface UserService {

    void update(RegisterRequestRecord request);

    List<SimpleMap> getAllUsers();

}
