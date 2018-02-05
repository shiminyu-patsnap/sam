package com.sam.feature.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author sam at 2017/12/28 下午2:13
 */
@Component
public class SamPublisher {

    @Autowired
    ApplicationContext context;

    public void publish(String msg) {
        context.publishEvent(new SamEvent(this, msg));
    }

}
