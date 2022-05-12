package com.box.SocNet.controller;

import com.box.SocNet.model.Post;
import com.box.SocNet.model.User;
import com.box.SocNet.service.PostService;
import com.box.SocNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public Post addPost(@RequestBody Post post,@PathVariable Long id) {
        User user = userService.getById(id);
        return postService.addPost(post, user);
    }


    @PutMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Post changePost(@RequestBody Post post) {
        return postService.changePost(post);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
