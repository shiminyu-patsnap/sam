package com.sam.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 16/6/1.
 */
@Service
public class AspectService implements IAspectService {

    private Logger logger = LoggerFactory.getLogger(AspectService.class);

    @Override
    public void sayHello(String email) {
        logger.debug("sayHello to >>>>{}", email);
    }
}
