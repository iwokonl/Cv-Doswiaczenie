package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;

public class BigWheels implements Wheels {
    String name;

    public BigWheels() {
        this.name = "Big wheels";
    }

    @Override
    public Wheels createWheels() {

        return new BigWheels();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
