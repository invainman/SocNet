package com.box.SocNet.service.impl;

import com.box.SocNet.model.*;
import com.box.SocNet.repository.*;
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
        User user = userRepository.findByProfile(getById(id));
        user.setProfile(null);
        Post post = postRepository.findByProfileId(id);
        if (post != null) {
            postRepository.delete(post);
        }
        Dialog dialog = dialogRepository.getByProfileId(id);
        if (dialog != null) {
            List<Message> messages = messageRepository.getAllByDialogId(dialog.getId());
            if (messages != null) {
                messageRepository.deleteAll(messages);
            }
            dialogRepository.delete(dialog);
        }
        profileRepository.deleteById(id);
    }
}