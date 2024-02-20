package com.litethinking.services;

import com.litethinking.entities.Product;
import com.litethinking.entities.User;
import com.litethinking.models.UserModel;
import com.litethinking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User usr){
        return userRepository.save(usr);
    }

    public User getById(Long id){
        return userRepository.getById(id);
    }

    public User login(UserModel usr){
        return userRepository.login(usr.getUsername());
    }
}
