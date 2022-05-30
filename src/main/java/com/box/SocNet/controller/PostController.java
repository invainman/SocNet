package com.box.SocNet.controller;

import com.box.SocNet.model.Post;
import com.box.SocNet.model.Profile;
import com.box.SocNet.service.PostService;
import com.box.SocNet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping("/{id}")
    public Post addPost(@RequestBody Post post,@PathVariable Long id) {
        return postService.addPost(post, id);
    }

    @PutMapping
    public Post changePost(@RequestBody Post post) {
        return postService.changePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
