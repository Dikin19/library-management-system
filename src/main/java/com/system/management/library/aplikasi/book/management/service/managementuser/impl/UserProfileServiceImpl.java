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

    public void update(UserProfileRequestRecord request) {


        var userProfileExisting = userProfileRepository.findById(request.id()).orElseThrow(() -> new RuntimeException("Data user tidak ditemukan"));

        if (userProfileRepository.existsByFullnameAndIdNot(request.fullname().toLowerCase(), request.id())) {
            throw new RuntimeException("fullname [" + request.fullname() + "] sudah digunakan");
        }
        if (userProfileRepository.existsByPhoneAndIdNot(request.phone().toLowerCase(), request.id())) {
            throw new RuntimeException("phone [" + request.phone() + "] sudah digunakan");
        }

        var userProfile = userProfileMapper.requestToEntity(request);
        userProfile.setId(userProfileExisting.getId());
        userProfileRepository.save(userProfile);
    }

}
