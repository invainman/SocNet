package com.box.SocNet.service;

import com.box.SocNet.model.User;
import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAll();

    User changeUser(User user);

    void deleteUser(Long id);

    List<User> getAllByEmail(String email);

    User getById(Long id);
}
