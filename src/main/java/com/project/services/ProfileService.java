package com.project.services;

import com.project.exceptions.NotFoundException;
import com.project.models.Profile;
import com.project.models.User;
import com.project.repositories.ProfileRepository;
import com.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserService userService;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileByUserId(Integer userId){
        User user = this.userService.getUserById(userId).orElseThrow(()->new NotFoundException("userId not found"));
        try{
            Profile profile = this.profileRepository.findByUser(user).orElseThrow(()->new NotFoundException("User not found"));
            return profile;
        }
        catch (NotFoundException e){
            return null;
        }
    }

    public void deleteProfile(Integer profileId) {
        profileRepository.deleteById(profileId);
    }

    public Profile updateProfile(Integer userId, Profile updatedProfile) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));

        Profile profile = profileRepository.findByUser(user).orElseThrow(()->new RuntimeException("User not found"));

        profile.setStatus(updatedProfile.getStatus());
        profile.setStatus(updatedProfile.getStatus());

        return profileRepository.save(profile);


    }
}

