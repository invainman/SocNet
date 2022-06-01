package com.box.SocNet.service;

import com.box.SocNet.model.Dialog;

import java.util.List;

public interface DialogService {

    List<Dialog> getAll();

    Dialog addDialog(Dialog dialog);

    void deleteDialog(Long id);
}
