package com.box.SocNet.repository;

import com.box.SocNet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByEmail(String email);

    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("delete from User u where u.profile.id=:id")
    void deleteById(@Param("id") @NonNull Long id);
}