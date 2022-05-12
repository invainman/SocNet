package com.box.SocNet.repository;

import com.box.SocNet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByEmail(String email);

    Optional<User> findByEmail(String email);

}