package FabrykaAbstrakcyjna.Car.Factory.Abstraction;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;
import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;

public interface CarFactory {
    Engine createEngine(String typeOf);
    Wheels createWheels(String typeOf);

}
