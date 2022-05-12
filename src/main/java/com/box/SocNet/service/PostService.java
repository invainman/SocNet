package com.box.SocNet.service;

import com.box.SocNet.model.Post;
import com.box.SocNet.model.User;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post addPost(Post post, User user);

    Post changePost(Post post);

    void deletePost(Long id);
}
