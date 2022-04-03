package com.box.SocNet.controller;

import com.box.SocNet.entity.Message;
import com.box.SocNet.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

   @PostMapping
    public Message addMessage(@RequestBody Message message) {
            return messageService.addMessage(message);
    }

    @GetMapping()
    public List<Message> getAll() {
       return messageService.getAll();
    }

    @PutMapping()
    public Message changeMessage(@RequestBody Message message) {
        return messageService.changeMessage(message);
    }

    @DeleteMapping()
    public void deleteMessage(@RequestBody Long id) {
       messageService.deleteMessage(id);
    }


}
