package com.box.SocNet.service.impl;

import com.box.SocNet.model.Post;
import com.box.SocNet.model.User;
import com.box.SocNet.repository.PostRepository;
import com.box.SocNet.repository.UserRepository;
import com.box.SocNet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post post, User user) {
        postRepository.save(post);
        List<Post> posts = user.getPosts();
        posts.add(post);
        User updatedUser = userRepository.save(user);
        return updatedUser.getPosts().stream().filter(p -> p.getId().equals(post.getId())).findAny().orElse(null);
    }

    @Override
    public Post changePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
