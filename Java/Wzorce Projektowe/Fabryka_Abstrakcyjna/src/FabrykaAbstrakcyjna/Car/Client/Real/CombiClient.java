package FabrykaAbstrakcyjna.Car.Client.Real;

import FabrykaAbstrakcyjna.Car.Car.Abstraction.Car;
import FabrykaAbstrakcyjna.Car.Car.Real.Combi;
import FabrykaAbstrakcyjna.Car.Client.Abstraction.Client;

public class CombiClient extends Client {
    @Override
    public Car makeCar(String typeOf) {
        return new Combi(carFactory,typeOf);
    }
}
