package FabrykaAbstrakcyjna.Car.Car.Abstraction;

import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;
import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;


public abstract class Car {
    protected String  typeOfCar;
    protected Engine engine;
    protected Wheels wheels;

    public abstract void creation(String typeOf);

    @Override
    public String toString() {
        return "Car{" +
                "typeOfCar='" + typeOfCar + '\'' +
                ", engine=" + engine.getName() +
                ", wheels=" + wheels.getName() +
                '}';
    }
}
