package com.sam.controller;

import com.sam.annotation.SamAspect;
import com.sam.config.Config;
import com.sam.feature.async.AsyncService;
import com.sam.feature.condition.ListService;
import com.sam.feature.event.SamPublisher;
import com.sam.feature.schedule.ScheduleService;
import com.sam.service.SamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 16/6/27.
 */
@RestController
public class SamController {

    private Logger logger = LoggerFactory.getLogger(SamController.class);

    @Autowired
    SamService service;

    @Autowired
    Config config;

    @Autowired
    SamPublisher publisher;

    @Autowired
    AsyncService asyncService;

    @Autowired
    ScheduleService scheduleService;

//    @Autowired
//    ListService listService;

    @SamAspect
    @RequestMapping("/hello")
    public String hello(@RequestParam("email") String email) {
        String name = service.queryUserName("shiminyu@qq.com");
        return "hello ! " + name;
    }

    @RequestMapping("/value")
    public void value() {
        logger.info(config.toString());
    }

    @RequestMapping("/event")
    public void event() {
        publisher.publish("into event controller");
        logger.info("publish done !!!");
    }

    @RequestMapping("/async")
    public void async() {
        asyncService.async1();
        asyncService.async2();
    }

    @RequestMapping("/schedule")
    public void schedule() {
        scheduleService.schedule();
    }

//    @RequestMapping("/condition")
//    public void condition() {
//        logger.info("os name is {}",listService.showName());
//    }
}
