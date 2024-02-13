package FabrykaAbstrakcyjna.Pizzae.Pizzerie;


import FabrykaAbstrakcyjna.Pizzae.Fabryki.FabrykaSkładnikówPizzy;
import FabrykaAbstrakcyjna.Pizzae.Fabryki.WłoskaFabrykaSkładnikówPizzy;
import FabrykaAbstrakcyjna.Pizzae.Pizza.Pizza;
import FabrykaAbstrakcyjna.Pizzae.Pizza.Serowa;

public class WłoskaPizzeria extends Pizzeria {
    Pizza pizza = null;
    FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy = new WłoskaFabrykaSkładnikówPizzy();
    protected Pizza utwórzPizze(String type){
        if(type.equals("serowa")){
            return new Serowa(fabrykaSkładnikówPizzy);
        }
        return pizza;
    }
}
