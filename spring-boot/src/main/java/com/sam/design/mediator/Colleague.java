package com.sam.design.mediator;

/**
 * @author sam at 2018/2/5 下午2:56
 */
public abstract class Colleague {

    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
