package com.rodenbostel.temperature.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by justinrodenbostel on 5/17/17.
 */
@Component
public class LogTask {

    private static final Logger log = LoggerFactory.getLogger(LogTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Current Time: " + dateFormat.format(new Date()));
    }
}
