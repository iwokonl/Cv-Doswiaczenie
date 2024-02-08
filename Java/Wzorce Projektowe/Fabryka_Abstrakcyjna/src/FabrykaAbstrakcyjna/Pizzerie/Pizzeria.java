package FabrykaAbstrakcyjna.Pizzerie;

import FabrykaAbstrakcyjna.Pizza.Pizza;

public abstract class Pizzeria {
    public Pizza zamówPizze(String type){

        Pizza pizza = utwórzPizze(type);

        pizza.krojenie();
        pizza.pakowanie();


        return pizza;

    }
    protected abstract Pizza utwórzPizze(String type);

}

