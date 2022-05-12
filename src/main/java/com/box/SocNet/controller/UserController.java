package com.box.SocNet.controller;

import com.box.SocNet.model.User;
import com.box.SocNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('user:read')")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('user:write')")
    public User changeUser(@RequestBody User user){
        return userService.changeUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasAuthority('user:read')")
    public List<User> getAllByEmail(@PathVariable String email) {
        return userService.getAllByEmail(email);
    }


}