package com.box.SocNet.service.impl;

import com.box.SocNet.model.Role;
import com.box.SocNet.model.User;
import com.box.SocNet.repository.UserRepository;
import com.box.SocNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user){
        if(user.getRole()== null){
            user.setRole(Role.USER);
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User changeUser(User user){
        if(user.getRole()== null){
            user.setRole(Role.USER);
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
