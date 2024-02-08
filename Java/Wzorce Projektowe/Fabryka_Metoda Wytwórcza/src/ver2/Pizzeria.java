package ver2;

public abstract class Pizzeria {
    public Pizza zamówPizze(){

    Pizza pizza = utwórzPizze();
    pizza.przygotowanie();
    pizza.pieczenie();
    pizza.krojenie();
    pizza.pakowanie();


    return pizza;

    }
    protected abstract Pizza utwórzPizze();

}
