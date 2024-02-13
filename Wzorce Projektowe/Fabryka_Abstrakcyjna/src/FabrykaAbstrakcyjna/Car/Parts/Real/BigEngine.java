package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;

public class BigEngine implements Engine {
    String name;

    public BigEngine(String liter) {
        this.name = "Big engine have" + liter;
    }

    @Override
    public Engine createEngine(String liter) {
        return new BigEngine(liter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
