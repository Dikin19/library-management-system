package com.system.management.library.aplikasi.book.management.service.managementuser.impl;


import com.system.management.library.aplikasi.book.management.mapper.managementuser.UserProfileMapper;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserProfileRepository;
import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ValidatorService validatorService;
    private final UserProfileMapper userProfileMapper;

    @Override
    public void create(UserProfileRequestRecord request){

        validatorService.validator(request);

        var userProfile = userProfileMapper.requestToEntity(request);
        userProfileRepository.save(userProfile);

    }

}
