package com.box.SocNet.controller;

import com.box.SocNet.model.Profile;
import com.box.SocNet.model.User;
import com.box.SocNet.service.ProfileService;
import com.box.SocNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @PostMapping("/{id}")
    public Profile addProfile(@RequestBody Profile profile, @PathVariable Long id) {
        User user = userService.getById(id);
        return profileService.addProfile(profile, user);
    }

    @PutMapping("/{id}")
    public Profile changeProfile(@RequestBody Profile profile, @PathVariable Long id) {
        return profileService.changeProfile(profile, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }
}
