package com.example.hyeonjunspringgg.designPattern.structural;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

interface ComputerDevice {
    int getPrice();
    int getPower();
}

@Getter
@AllArgsConstructor
class Speaker implements ComputerDevice {
    private int price;
    private int power;
}
@Getter
@AllArgsConstructor
class Keyboard implements ComputerDevice {
    private int price;
    private int power;
}
@Getter
@AllArgsConstructor
class Mouse implements ComputerDevice {
    private int price;
    private int power;
}

class Computer implements ComputerDevice {

    private List<ComputerDevice> computerDevices = new ArrayList<>();

    public void addDevice(ComputerDevice computerDevice) {
        computerDevices.add(computerDevice);
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getPower() {
        return 0;
    }
}