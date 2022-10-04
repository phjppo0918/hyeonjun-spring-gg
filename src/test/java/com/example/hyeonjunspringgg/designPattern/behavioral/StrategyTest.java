package com.example.hyeonjunspringgg.designPattern.behavioral;

import lombok.Getter;
import lombok.Setter;

class Atom extends Robot {
    public Atom(String name) {
        super(name);
    }
}

class FlyingStrategy implements MovingStrategy {

    @Override
    public void move() {

    }
}

abstract class Robot {
    @Getter
    private String name;
    @Setter
    private MovingStrategy movingStrategy;

    @Setter
    private AttackStrategy attackStrategy;




    public Robot(String name) {
        this.name = name;
    }

    public void move() {
        movingStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }
}


interface MovingStrategy {
    void move();
}

interface AttackStrategy {
    void attack();
}



public class StrategyTest {
    Robot aTom = new Atom("atom");

    void test() {
        aTom.setMovingStrategy(new FlyingStrategy());
    }

}
