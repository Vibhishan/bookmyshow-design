package me.vibhishanranga.bookmyshowdesign.services;

import me.vibhishanranga.bookmyshowdesign.models.User;
import me.vibhishanranga.bookmyshowdesign.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(String email){
        User user = new User();
        user.setEmail(email);

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
