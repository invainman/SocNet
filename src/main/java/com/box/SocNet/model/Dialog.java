package com.box.SocNet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dialogs")
public class Dialog {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "profile1_id")
    private Long firstProfileId;
    @Column(name = "profile2_id")
    private Long secondProfileId;
    @OneToMany(mappedBy = "dialogId")
    private List<Message> messages;

    public Dialog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Long getFirstProfileId() {
        return firstProfileId;
    }

    public void setFirstProfileId(Long firstProfileId) {
        this.firstProfileId = firstProfileId;
    }

    public Long getSecondProfileId() {
        return secondProfileId;
    }

    public void setSecondProfileId(Long secondProfileId) {
        this.secondProfileId = secondProfileId;
    }
}
