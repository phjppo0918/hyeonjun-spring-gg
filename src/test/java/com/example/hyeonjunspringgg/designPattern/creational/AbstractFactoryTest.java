package com.example.hyeonjunspringgg.designPattern.creational;

abstract class ElevatorFactory {
    // 추상 부품을 생성하는 추상 팩토리
    public abstract Moter createModer();
    public abstract Door createDoor();

}

class LGElevatorFactory extends ElevatorFactory{

    @Override
    public LGMoter createModer() {
        return null;
    }

    @Override
    public LGDoor createDoor() {
        return null;
    }
}

class HDElevatorFactory extends ElevatorFactory{

    @Override
    public HDMoter createModer() {
        return null;
    }

    @Override
    public HDDoor createDoor() {
        return null;
    }
}

class LGMoter extends Moter {

}

class HDMoter extends Moter {

}

class LGDoor extends Door {

}

class HDDoor extends Door {

}
class Moter {

}
class Door{

}

public class AbstractFactoryTest {
}
