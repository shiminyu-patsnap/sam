package com.sam.feature.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sam at 2018/1/30 下午3:07
 */
@Service
public class AsyncService {

    private Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void async1() {
        for (int i = 0; i < 10; i++) {
            logger.info("currnet number is " + i);
        }
    }

    @Async
    public void async2() {
        for (int i = 20; i < 30; i++) {
            logger.info("currnet number is " + i);
        }
    }
}
