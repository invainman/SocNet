package com.box.SocNet.repository;

import com.box.SocNet.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByProfileId (Long profileId);
}
