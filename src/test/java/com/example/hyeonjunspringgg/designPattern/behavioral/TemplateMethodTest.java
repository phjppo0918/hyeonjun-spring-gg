package com.example.hyeonjunspringgg.designPattern.behavioral;


abstract class HouseTemplate {
    public final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildWindows();
    }

    private void buildWindows() {

    }
    private void buildFoundation() {

    }

    public abstract void buildWalls();

}
class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {

    }
}

class WoodHouse extends HouseTemplate {

    @Override
    public void buildWalls() {

    }
}

public class TemplateMethodTest {
}
