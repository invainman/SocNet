package com.box.SocNet.service.impl;

import com.box.SocNet.model.*;
import com.box.SocNet.repository.*;
import com.box.SocNet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

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
    public Profile changeProfile(Profile profile, Long id) {
        profile.setId(id);
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        userRepository.deleteById(id);
        postRepository.deleteAllByProfileId(id);
        List<Dialog> dialogs = dialogRepository.findAllByProfileId(id);
        for (Dialog dialog:dialogs) {
            if(Objects.equals(dialog.getFirstProfileId(), id)){
                dialog.setFirstProfileId(null);
            }
            if (Objects.equals(dialog.getSecondProfileId(), id)){
                dialog.setSecondProfileId(null);
            }
        }
        List<Message> messages = messageRepository.getAllByProfileId(id);// сделать в одну строку через query
        for (Message message:messages) {
            message.setProfileId(null);
        }
        profileRepository.deleteById(id);
    }
}