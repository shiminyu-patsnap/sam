package com.sam.design.mediator;

/**
 * @author sam at 2018/2/24 下午2:38
 */
public class ColleagueMediator implements Mediator {

    private ConcreteColleagueA concreteColleagueA;

    private ConcreteColleagueB concreteColleagueB;


    @Override
    public void changed(Colleague colleague) {

    }

    public ConcreteColleagueA getConcreteColleagueA() {
        return concreteColleagueA;
    }

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public ConcreteColleagueB getConcreteColleagueB() {
        return concreteColleagueB;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }
}
