package FabrykaAbstrakcyjna.Car.Factory.Real;

import FabrykaAbstrakcyjna.Car.Factory.Abstraction.CarFactory;
import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Engine;
import FabrykaAbstrakcyjna.Car.Parts.Abstraction.Wheels;
import FabrykaAbstrakcyjna.Car.Parts.Real.*;


public class CombiFactory implements CarFactory {
    @Override
    public Engine createEngine(String typeOf) {
        Engine engine = null;
        if (typeOf.toLowerCase().equals("small")){
            return new SmallEngine("1.0");
        } else if (typeOf.toLowerCase().equals("mid")) {
            return new MidEngine("1.2");
        }
        else if (typeOf.toLowerCase().equals("big")) {
            return new BigEngine("1.5");
        }
        return engine;
    }

    @Override
    public Wheels createWheels(String typeOf) {
        Wheels wheels = null;
        if (typeOf.toLowerCase().equals("small")){
            return new SmallWheels();
        } else if (typeOf.toLowerCase().equals("mid")) {
            return new MidWheels();
        }
        else if (typeOf.toLowerCase().equals("big")) {
            return new BigWheels();
        }
        return wheels;
    }


}
