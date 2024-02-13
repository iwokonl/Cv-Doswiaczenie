package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;

public class MidEngine implements Engine {
    String name;
    public MidEngine(String liter) {
        this.name = "Mid engine have" + liter;
    }


    @Override
    public Engine createEngine(String liter) {
        return new MidEngine(liter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
