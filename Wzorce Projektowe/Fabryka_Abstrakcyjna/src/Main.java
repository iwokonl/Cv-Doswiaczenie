import FabrykaAbstrakcyjna.Pizza.Pizza;
import FabrykaAbstrakcyjna.Pizzerie.Pizzeria;
import FabrykaAbstrakcyjna.Pizzerie.WłoskaPizzeria;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new WłoskaPizzeria();
        Pizza serowa = pizzeria.zamówPizze("serowa");
        System.out.println(serowa.toString());
    }
}