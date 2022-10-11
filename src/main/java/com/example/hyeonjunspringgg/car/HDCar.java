package com.example.hyeonjunspringgg.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

class Client {
    HDCar hdCar = new HDCar(new HDCarStarter());
}

@Configuration
class Config {



}

@Component
public class HDCar {
    CarStarter carStarter;
    //CarStarter carStarter = new HDCarStarter();

    @Autowired
    public HDCar(CarStarter carStarter) {
        this.carStarter = carStarter;
    }

    void run() {
        carStarter.start("qwerqewr");
    }
}

@Component

class HDCarStarter extends CarStarter {

    @Override
    public boolean cert(String key) {
        return false;
    }
}
