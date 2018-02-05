package com.sam.feature.condition;

import org.springframework.stereotype.Service;

/**
 * @author sam at 2018/1/30 下午3:34
 */
public class WindowService implements ListService{

    @Override
    public String showName() {
        return "WINDOW";
    }
}
