package FabrykaAbstrakcyjna.Car.Parts.Real;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;

public class SmallWheels  implements Wheels {
    String name;

    public SmallWheels() {
        this.name = "Small wheels";
    }

    @Override
    public Wheels createWheels() {

        return new SmallWheels();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
