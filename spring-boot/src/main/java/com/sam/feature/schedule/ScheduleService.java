package com.sam.feature.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sam at 2018/1/30 下午3:14
 */
@Service
public class ScheduleService {

    private Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss ");

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void schedule() {
        logger.info("time..{}", sdf.format(new Date()));
    }

}
