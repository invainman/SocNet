package com.box.SocNet.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "profile_id")
    private Long profileId;

    public Post() {
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

    public Long getProfile_id() {
        return profileId;
    }

    public void setProfile_id(Long profileId) {
        this.profileId = profileId;
    }
}
