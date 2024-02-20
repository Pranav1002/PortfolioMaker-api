package com.project.controllers;

import com.project.exceptions.NotFoundException;
import com.project.models.Profile;
import com.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{profileId}")
    public Profile getProfileById(@PathVariable Integer profileId) {
        return profileService.getProfileById(profileId)
                .orElseThrow(() -> new NotFoundException("Profile not found with id: " + profileId));
    }

    @PutMapping("/{profileId}")
    public Profile updateProfile(@PathVariable Integer profileId, @RequestBody Profile updatedProfile) {
        return profileService.updateProfile(profileId, updatedProfile);
    }

    @DeleteMapping("/{profileId}")
    public void deleteProfile(@PathVariable Integer profileId) {
        profileService.deleteProfile(profileId);
    }
}

