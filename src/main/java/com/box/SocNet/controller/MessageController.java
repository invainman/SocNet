package com.box.SocNet.controller;

import com.box.SocNet.model.Message;
import com.box.SocNet.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

   @PostMapping
   @PreAuthorize("hasAuthority('user:write')")
    public Message addMessage(@RequestBody Message message) {
            return messageService.addMessage(message);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Message> getAll() {
       return messageService.getAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Message changeMessage(@RequestBody Message message) {
        return messageService.changeMessage(message);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteMessage(@PathVariable Long id) {
       messageService.deleteMessage(id);
    }

}