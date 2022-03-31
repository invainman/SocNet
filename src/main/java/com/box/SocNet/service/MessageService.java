package com.box.SocNet.service;

import com.box.SocNet.entity.Message;

import java.util.List;

public interface MessageService {

    Message addMessage(Message message);

    List<Message> getAll();

    void deleteMessage(Long id);

    Message changeMessage(Message message);
}


