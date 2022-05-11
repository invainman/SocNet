package com.box.SocNet.service;

import com.box.SocNet.model.Profile;
import java.util.List;

public interface ProfileService {

    List<Profile> getAll();

    Profile addProfile(Profile profile);

    Profile changeProfile(Profile profile);

    void deleteProfile(Long id);
}
