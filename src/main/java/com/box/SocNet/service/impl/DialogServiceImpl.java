package com.box.SocNet.service.impl;

import com.box.SocNet.model.Dialog;
import com.box.SocNet.repository.DialogRepository;
import com.box.SocNet.repository.MessageRepository;
import com.box.SocNet.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Dialog> getAll() {
        return dialogRepository.findAll();
    }

    @Override
    public Dialog addDialog(Dialog dialog) {
        return dialogRepository.save(dialog);
    }

    @Override
    public void deleteDialog(Long id) {
        messageRepository.deleteAllByDialogId(id);
        dialogRepository.deleteById(id);
    }

    @Override
    public List<Dialog> findAllByProfileId(Long id) {
        return dialogRepository.findAllByProfileId(id);
    }
}
