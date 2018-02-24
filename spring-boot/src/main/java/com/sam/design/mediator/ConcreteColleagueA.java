package com.sam.design.mediator;

/**
 * @author sam at 2018/2/24 下午2:35
 */
public class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    public void someOperation() {
        getMediator().changed(this);
    }
}
