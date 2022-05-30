package com.box.SocNet.service.impl;

import com.box.SocNet.model.Post;
import com.box.SocNet.model.Profile;
import com.box.SocNet.repository.PostRepository;
import com.box.SocNet.repository.ProfileRepository;
import com.box.SocNet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post post, Long id) {
        post.setProfile_id(id);
        postRepository.save(post);
        Profile profile = profileRepository.getById(id);
        List<Post> posts = profile.getPosts();
        posts.add(post);
        profileRepository.save(profile);
        return post;
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