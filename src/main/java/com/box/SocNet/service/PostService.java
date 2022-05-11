package com.box.SocNet.service;

import com.box.SocNet.model.Post;
import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post addPost(Post post);

    Post changePost(Post post);

    void deletePost(Long id);
}
