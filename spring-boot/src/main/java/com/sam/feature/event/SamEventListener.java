package com.sam.feature.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author sam at 2017/12/28 下午12:28
 */
@Component
public class SamEventListener implements ApplicationListener<SamEvent> {

    private Logger logger = LoggerFactory.getLogger(SamEventListener.class);

    @Override
    public void onApplicationEvent(SamEvent samEvent) {
        logger.info("listening...{}", samEvent.getMsg());
    }
}
