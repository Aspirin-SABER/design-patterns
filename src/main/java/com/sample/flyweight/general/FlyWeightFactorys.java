package com.sample.flyweight.general;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 享元工厂
 */
public class FlyWeightFactorys {

    private static Map<String,IFlyWeight> pool = new ConcurrentHashMap<>();

    public static IFlyWeight getFlyweight(String instrsicState){
        if(!pool.containsKey(instrsicState)){
            pool.put(instrsicState,new ConcreteFlyWeight(instrsicState));
        }
        return pool.get(instrsicState);
    }
}
