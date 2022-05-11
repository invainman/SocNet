package com.box.SocNet.controller;

import com.box.SocNet.model.Profile;
import com.box.SocNet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Profile addProfile(@RequestBody Profile profile) {
        return profileService.addProfile(profile);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Profile changeProfile(@RequestBody Profile profile) {
        return profileService.changeProfile(profile);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }

}
