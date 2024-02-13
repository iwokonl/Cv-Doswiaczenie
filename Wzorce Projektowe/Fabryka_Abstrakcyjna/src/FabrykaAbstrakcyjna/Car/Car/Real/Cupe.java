package FabrykaAbstrakcyjna.Car.Car.Real;

import FabrykaAbstrakcyjna.Car.Car.Abstraction.Car;
import FabrykaAbstrakcyjna.Car.Factory.Abstraction.CarFactory;

public class Cupe extends Car {
    CarFactory carFactory;
    public Cupe(CarFactory carFactory, String typeOf) {
        this.carFactory = carFactory;
        creation(typeOf);

    }

    @Override
    public void creation(String typeOf) {
        engine = carFactory.createEngine(typeOf);
        wheels = carFactory.createWheels(typeOf);
        typeOfCar = "Cupe";
    }
}
