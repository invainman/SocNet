package com.box.SocNet.controller;

import com.box.SocNet.model.Dialog;
import com.box.SocNet.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dialogs")
public class DialogController {

    @Autowired
    private DialogService dialogService;

    @GetMapping
    public List<Dialog> getAll(){
        return dialogService.getAll();
    }

    @PostMapping
    public Dialog addDialog(@RequestBody Dialog dialog){
        return dialogService.addDialog(dialog);
    }

    @DeleteMapping("/{id}")
    public void deleteDialog(@PathVariable Long id) {
        dialogService.deleteDialog(id);
    }
}
