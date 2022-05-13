package com.box.SocNet.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Long id_to;
    private Long id_from;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId_to() {
        return id_to;
    }

    public void setId_to(Long id_to) {
        this.id_to = id_to;
    }

    public Long getId_from() {
        return id_from;
    }

    public void setId_from(Long id_from) {
        this.id_from = id_from;
    }
}