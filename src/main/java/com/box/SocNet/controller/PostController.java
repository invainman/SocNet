package com.box.SocNet.controller;

import com.box.SocNet.model.Post;
import com.box.SocNet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
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
