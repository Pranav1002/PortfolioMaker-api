package com.project.services;

import com.project.dto.LoginDto;
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
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;


    public User createUser(User user) {

        //Creating default profile at the time of creating user.

        User user1 = this.userRepository.save(user);
        Profile profile = new Profile();
        profile.setUser(user1);
        profile.setStatus("Private");
        profile.setTemplate("Classic");
        this.profileRepository.save(profile);

        return user1;


    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, User updatedUser) {
        if (userRepository.existsById(userId)) {
            updatedUser.setUserId(userId);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public User loginUser(LoginDto loginDto)
    {
        User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword()).orElseThrow(()-> new NotFoundException("Wrong credentials"));

        return user;
    }
}
