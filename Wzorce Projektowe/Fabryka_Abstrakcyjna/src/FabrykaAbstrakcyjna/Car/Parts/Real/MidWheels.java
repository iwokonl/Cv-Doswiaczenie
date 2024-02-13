package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;

public class MidWheels  implements Wheels {
    String name;

    public MidWheels() {
        this.name = "Mid wheels";
    }

    @Override
    public Wheels createWheels() {

        return new MidWheels();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
