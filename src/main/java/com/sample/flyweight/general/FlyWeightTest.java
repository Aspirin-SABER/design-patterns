package com.sample.flyweight.general;

public class FlyWeightTest {

    public static void main(String[] args) {
        IFlyWeight flyweight = FlyWeightFactorys.getFlyweight("aa");
        flyweight.operation("a");
        IFlyWeight flyweighta = FlyWeightFactorys.getFlyweight("aa");
        flyweighta.operation("bb");
    }
}
