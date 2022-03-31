package com.box.SocNet.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Config {

    @Autowired
    private Notification timeNotification;

    @Bean
    public void testSingleton(){
        Date date = new Date();
        timeNotification.setDate(date);
        System.out.println(timeNotification.getDate());

    }
}
