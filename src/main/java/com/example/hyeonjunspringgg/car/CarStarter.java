package com.example.hyeonjunspringgg.car;

public abstract class CarStarter {

    public void start(String key) {
        if(cert(key)) {
            // 차 시동 걸기~
            System.out.println("부릉부릉~");
        }
    }

    public abstract boolean cert(String key);
}
