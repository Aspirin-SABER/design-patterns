package com.sample.flyweight.general;

/***
 * 具体享元对象
 */
public class ConcreteFlyWeight implements IFlyWeight {

    private String instrsicState;

    public ConcreteFlyWeight(String instrsicState) {
        this.instrsicState = instrsicState;
    }

    @Override
    public void operation(String extraStat) {
        System.out.println("Object hascode"+System.identityHashCode(this));
        System.out.println("ExtraStat"+extraStat);
        System.out.println("InstrsicState"+this.instrsicState
        );
    }
}
