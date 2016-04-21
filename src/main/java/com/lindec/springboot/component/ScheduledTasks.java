package com.lindec.springboot.component;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lindec on 2016/4/8.
 */
//@Controller
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "1/5 * * * * * ")
    public void reportTime() {
        System.out.println("lalalalallala " + dateFormat.format(new Date()));
    }


}
