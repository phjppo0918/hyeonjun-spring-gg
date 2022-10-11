package com.example.hyeonjunspringgg.designPattern.behavioral;

import lombok.Setter;

interface Command {
    void execute();
}

class Button {
    @Setter
    private Command command;

    public Button(Command command) {
        setCommand(command);
    }

    public void pressed() {
        command.execute();
    }
}

class Lamp {
    public void turnOn() {
        System.out.println("Lamp On");
    }
}

class LampOnCommand implements Command {

    private Lamp lamp;

    public LampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOn();
    }
}

public class CommandTest {
    void test() {
        Lamp lamp = new Lamp();
        Command lampOnCommand = new LampOnCommand(lamp);
        Button button = new Button(lampOnCommand);

        button.pressed();
    }

}
