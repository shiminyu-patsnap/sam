package com.sam.controller;

import com.sam.aop.service.AspectService;
import com.sam.dao.UserDao;
import com.sam.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sam on 16/5/26.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    UserDao userDao;

    @Autowired
    AspectService aspectService;

    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/world")
    public String hello(Model model) {
        String email = "sam@balabala.com";
        String name = userDao.queryUserNameByEmail(email);
        User user = userDao.queryUserInfoByEmail(email);

        logger.debug("you have been here !");
        model.addAttribute("hello", "您好! " + name);
        model.addAttribute("world", "everything is " + user.getUserId());
        return "sam";
    }

    @RequestMapping("/test")
    public String test(Model model){
        logger.debug(">>>>>>>>我就测试下日志 debug  <<<<<<<<<");
        logger.info(">>>>>>>> 我就测试下日志 info   <<<<<<<<<");
        model.addAttribute("hello", "您好! test");
        model.addAttribute("world", "everything is id");
        return "sam";
    }

    @RequestMapping("/aop")
    public String aop(Model model){
        model.addAttribute("hello", "AOP");
        model.addAttribute("world", "everything is AOP");
        aspectService.sayHello("sam@balabala.com");
        return "sam";
    }


}
