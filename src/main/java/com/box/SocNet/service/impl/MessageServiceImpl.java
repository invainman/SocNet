package com.box.SocNet.service.impl;

import com.box.SocNet.entity.Message;
import com.box.SocNet.repository.MessageRepository;
import com.box.SocNet.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message changeMessage(Message message) {
        return messageRepository.save(message);
    }


}
