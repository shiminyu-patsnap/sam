package com.sam.annotation;

import java.lang.annotation.*;

/**
 * aspectj注解
 * @author sam at 2017/12/27 下午4:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SamAspect {
}
