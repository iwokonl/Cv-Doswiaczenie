package Pizzeria_ver1;

public abstract class Pizzeria {
    public Pizza zamówPizze(String type){
    Pizza pizza = null;
    pizza = utwórzPizze(type);
    pizza.przygotowanie();
    pizza.pieczenie();
    pizza.krojenie();
    pizza.pakowanie();


    return pizza;

    }
    protected abstract Pizza utwórzPizze(String type);

}
