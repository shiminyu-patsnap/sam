package com.sam.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 切面类
 * Created by sam on 16/6/1.
 */
public class AspectjLog {

    private Logger logger = LoggerFactory.getLogger(AspectjLog.class);

    //此处定义一个通用的切点,以便下方4个通知使用
    public void logAop() {
    }

    public void logBefore(String email) {
        logger.debug("前置通知Before>>{}", email);
    }

    public void logAfterReturning(String email) {
        logger.debug("返回通知AfterReturning>>{}", email);
    }

    public void logAfter(String email) {
        logger.debug("后置通知After>>{}", email);
    }

    public void logAfterThrow(String email) {
        logger.debug("异常通知AfterThrowing>>{}", email);
    }

    //环绕通知功能很强,可以替代上面的所有通知
    /*
    @Around("logAop() && args(email)")
    public void logAround(ProceedingJoinPoint jp, String email) {
        try {
            logger.debug("自定义前置通知Before>>>{}", email);
            jp.proceed();//将控制权交给被通知的方法，也就是执行sayHello方法
            logger.debug("自定义后置通知After>>>{}", email);
        } catch (Throwable throwable) {
            logger.debug("异常处理>>>>{}", email);
            throwable.printStackTrace();
        }
    }
    */
}


