package com.sam.feature.event;

import org.springframework.context.ApplicationEvent;

/**
 * 继承ApplicationEvent
 *
 * @author sam at 2017/12/28 下午12:27
 */
public class SamEvent extends ApplicationEvent {

    private String msg;

    public SamEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
