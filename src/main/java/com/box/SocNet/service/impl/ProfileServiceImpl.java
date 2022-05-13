package com.box.SocNet.service.impl;

import com.box.SocNet.model.Profile;
import com.box.SocNet.model.User;
import com.box.SocNet.repository.ProfileRepository;
import com.box.SocNet.repository.UserRepository;
import com.box.SocNet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile addProfile(Profile profile, User user) {
        profileRepository.save(profile);
        user.setProfile(profile);
        userRepository.save(user);
        return user.getProfile();
    }

    @Override
    public Profile changeProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
