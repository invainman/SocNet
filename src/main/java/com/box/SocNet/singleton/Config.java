package com.box.SocNet.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
public class Config {

    @Autowired
    private Notification timeNotification1;

    @Autowired
    private Notification timeNotification2;

    @Bean
    public void testSingleton() throws InterruptedException {
        Date date = new Date();
        timeNotification1.setDate(date);
        System.out.println("server started in " + timeNotification1.getDate());
        System.out.println("server started in " + timeNotification2.getDate());

        Thread.sleep(5000);

        Date date2 = new Date();
        timeNotification2.setDate(date2);
        System.out.println("server started in " + timeNotification1.getDate() + " (not right time)");
        System.out.println("server started in " + timeNotification2.getDate() + " (not right time)");
    }
}
