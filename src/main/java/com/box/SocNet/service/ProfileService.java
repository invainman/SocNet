package com.box.SocNet.service;

import com.box.SocNet.model.Profile;
import com.box.SocNet.model.User;
import java.util.List;

public interface ProfileService {

    List<Profile> getAll();

    Profile addProfile(Profile profile, User user);

    Profile changeProfile(Profile profile);

    void deleteProfile(Long id);

    Profile getById (Long id);
}
