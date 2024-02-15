package FabrykaAbstrakcyjna.Car.Client.Real;

import FabrykaAbstrakcyjna.Car.Car.Abstraction.Car;
import FabrykaAbstrakcyjna.Car.Car.Real.Cupe;
import FabrykaAbstrakcyjna.Car.Client.Abstraction.Client;
import FabrykaAbstrakcyjna.Car.Factory.Real.CupeFactory;

public class CupeClient extends Client {
    @Override
    public Car makeCar(String typeOf) {
        return new Cupe(carFactory,typeOf);
    }

}
