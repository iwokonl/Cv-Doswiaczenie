package FabrykaAbstrakcyjna.Car.Client.Abstraction;

import FabrykaAbstrakcyjna.Car.Car.Abstraction.Car;
import FabrykaAbstrakcyjna.Car.Factory.Abstraction.CarFactory;

public abstract class Client {
    public CarFactory carFactory;
    public Car orderCar(CarFactory carFactory,String typeOf){
        this.carFactory = carFactory;
        Car car = makeCar(typeOf);
        System.out.println(car.toString());
        return car;
    }

    public abstract Car makeCar(String typeOf);
}
