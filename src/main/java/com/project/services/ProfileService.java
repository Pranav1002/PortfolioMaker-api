package com.project.services;

import com.project.models.Profile;
import com.project.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Integer profileId) {
        return profileRepository.findById(profileId);
    }

    public void deleteProfile(Integer profileId) {
        profileRepository.deleteById(profileId);
    }

    public Profile updateProfile(Integer profileId, Profile updatedProfile) {
        if (profileRepository.existsById(profileId)) {
            updatedProfile.setId(profileId);
            return profileRepository.save(updatedProfile);
        }
        return null;
    }
}

