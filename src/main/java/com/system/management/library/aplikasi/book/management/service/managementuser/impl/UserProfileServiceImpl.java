package com.system.management.library.aplikasi.book.management.service.managementuser.impl;


import com.system.management.library.aplikasi.book.management.entity.managementuser.UserProfile;
import com.system.management.library.aplikasi.book.management.entity.master.Book;
import com.system.management.library.aplikasi.book.management.entity.master.Category;
import com.system.management.library.aplikasi.book.management.mapper.managementuser.UserProfileMapper;
import com.system.management.library.aplikasi.book.management.model.app.SimpleMap;
import com.system.management.library.aplikasi.book.management.model.request.UserProfileRequestRecord;
import com.system.management.library.aplikasi.book.management.repository.managementuser.UserProfileRepository;
import com.system.management.library.aplikasi.book.management.service.app.ValidatorService;
import com.system.management.library.aplikasi.book.management.service.managementuser.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
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

    @Override
    public List<SimpleMap> getAllProfiles() {
        List<UserProfile> profiles = userProfileRepository.findAll();

        return profiles.stream().map(profile -> {
            SimpleMap data = new SimpleMap();
            data.add("id", profile.getId());
            data.add("fullname", profile.getFullname());
            data.add("phone", profile.getPhone());
            data.add("address", profile.getAddress());
            data.add("status", profile.getStatus());
            data.add("role", profile.getRole());

            return data;
        }).collect(Collectors.toList());
    }

}
