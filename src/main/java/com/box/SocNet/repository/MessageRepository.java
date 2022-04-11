package com.box.SocNet.repository;

import com.box.SocNet.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT m FROM Message m where m.tag like :tag")
    List<Message> getMessageByTag(String tag);
}
