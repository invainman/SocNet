package com.box.SocNet.controller;

import com.box.SocNet.entity.User;
import com.box.SocNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping()
    public List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping()
    public User changeUser(@RequestBody User user){
        return userService.changeUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{email}")
    public List<User> getAllByEmail(@PathVariable String email) {
        return userService.getAllByEmail(email);
    }
}
