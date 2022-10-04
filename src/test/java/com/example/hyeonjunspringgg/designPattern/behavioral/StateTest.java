package com.example.hyeonjunspringgg.designPattern.behavioral;

class ON implements State {

    @Override
    public void onPush(Light light) {
        //작동안함
    }

    @Override
    public void offPush(Light light) {
        System.out.println("불 꺼짐");
    }
}

class OFF implements State {

    @Override
    public void onPush(Light light) {
        System.out.println("불 켜짐");
    }

    @Override
    public void offPush(Light light) {
        //작동안함
    }
}

class Light {
    private State state;

    public Light() {
        state = new OFF();
    }
}
interface State {
    void onPush(Light light);
    void offPush(Light light);
}
public class StateTest {

}
