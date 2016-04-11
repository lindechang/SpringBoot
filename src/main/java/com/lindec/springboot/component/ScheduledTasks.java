package com.lindec.springboot.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lindec on 2016/4/8.
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 2 17 * * * ")
    public void reportTime() {
        System.out.println("lalalalallala " + dateFormat.format(new Date()));
    }

}
