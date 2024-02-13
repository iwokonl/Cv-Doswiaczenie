package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;

public class SmallEngine implements Engine {
    String name;

    public SmallEngine(String liter) {
        this.name = "Small engine have "+ liter;
    }

    @Override
    public Engine createEngine(String liter) {
        this.name = "Small engine have "+ liter;
        return new SmallEngine(liter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
