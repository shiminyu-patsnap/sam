package com.sam.design.mediator;

/**
 * @author sam at 2018/2/24 下午2:37
 */
public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void someOperation(){
        getMediator().changed(this);
    }
}
