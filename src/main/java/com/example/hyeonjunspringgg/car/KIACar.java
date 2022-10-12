package com.example.hyeonjunspringgg.car;

public class KIACar {
    CarStarter carStarter = new CarStarter() {
        @Override
        public boolean cert(String key) {
            return false;
        }
    };


    void run() {
        carStarter.start("qwerqewr");
    }
}
