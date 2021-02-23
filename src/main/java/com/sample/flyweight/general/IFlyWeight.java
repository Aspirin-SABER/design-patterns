package com.sample.flyweight.general;

/***
 * 享元模式（Flywight Pattern）又叫轻量级模式，是对象池的一种实现。
 * 类似于线程池，线程池避免了频繁地创建和销毁对象，消耗性能。提供了减少对象数量从而改善应用所需的对象结构的方式。
 * 宗旨：共享细粒度对象，将多个对同一对象的访问集中起来。
 * 数据结构型模式
 */
//抽象享元对象
public interface IFlyWeight {
    void operation(String extraStat);
}
