package com.box.SocNet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dialogs")
public class Dialog {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "profile_id")
    private Long profileId;
    @Column(name = "id_to")
    private Long idTo;
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
