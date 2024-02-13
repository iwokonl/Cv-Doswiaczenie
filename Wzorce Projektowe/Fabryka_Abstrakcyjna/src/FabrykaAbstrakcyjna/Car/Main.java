package FabrykaAbstrakcyjna.Car;

import FabrykaAbstrakcyjna.Car.Car.Abstraction.Car;
import FabrykaAbstrakcyjna.Car.Client.Abstraction.Client;
import FabrykaAbstrakcyjna.Car.Client.Real.CupeClient;
import FabrykaAbstrakcyjna.Car.Factory.Abstraction.CarFactory;
import FabrykaAbstrakcyjna.Car.Factory.Real.CupeFactory;

public class Main {
    public static void main(String[] args) {
        Client carFactory = new CupeClient();
        Car car = carFactory.orderCar(new CupeFactory(),"big");
    }
}
