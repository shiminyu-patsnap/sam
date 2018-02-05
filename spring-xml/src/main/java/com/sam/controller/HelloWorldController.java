package com.sam.controller;

import com.sam.aop.service.AspectService;
import com.sam.dao.UserDao;
import com.sam.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sam on 16/5/31.
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
        String email = "shimy@raiyee.com";
        String name = userDao.queryUserNameByEmail(email);
        User user = userDao.queryUserInfoByEmail(email);

        logger.debug("you have been here !");
        model.addAttribute("world", "everything is " + user.getUserId());
        model.addAttribute("hello", "您好! " + name);
        return "sam";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        logger.info(">>>>>>>> 我就测试下日志 info   <<<<<<<<<");
        logger.debug(">>>>>>>>我就测试下日志 debug  <<<<<<<<<");
        model.addAttribute("hello", "您好! test");
        model.addAttribute("world", "everything is id");
        return "sam";
    }

    @RequestMapping("/aop")
    public String aop(Model model) {
        aspectService.sayHello("sam@balabala.com");

        model.addAttribute("hello", "您好! AOP");
        model.addAttribute("world", "everything is AOP");
        return "sam";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/check")
    public String check(String username, String password, Model model) {
        logger.debug("username>>>{},password>>>{}", username, password);

        model.addAttribute("world", "everything is " + username);
        model.addAttribute("hello", "您好! " + password);
        return "sam";
    }
}