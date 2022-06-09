package com.box.SocNet.repository;

import com.box.SocNet.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Transactional
    void deleteAllByDialogId(Long dialogId);

    List<Message> getAllByProfileId(Long profileId);
}