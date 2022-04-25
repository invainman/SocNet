package com.box.SocNet.service;

import com.box.SocNet.model.Message;
import java.util.List;

public interface MessageService {

    Message addMessage(Message message);

    List<Message> getAll();

    void deleteMessage(Long id);

    List<Message> getAllByTag(String tag);

    Message changeMessage(Message message);
}


