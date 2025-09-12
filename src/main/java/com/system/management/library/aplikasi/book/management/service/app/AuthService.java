package com.system.management.library.aplikasi.book.management.service.app;

import com.system.management.library.aplikasi.book.management.entity.managementuser.User;
import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.LoginRequestRecord;
import com.system.management.library.aplikasi.book.management.model.request.RegisterRequestRecord;

public interface AuthService {

    void register(RegisterRequestRecord request);

    SimpleMap login(LoginRequestRecord request);

    void logout(User userLogout);


}
