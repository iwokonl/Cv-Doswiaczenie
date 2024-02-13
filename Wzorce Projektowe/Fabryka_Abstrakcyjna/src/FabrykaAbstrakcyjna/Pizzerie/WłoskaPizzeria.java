package FabrykaAbstrakcyjna.Pizzerie;


import FabrykaAbstrakcyjna.Fabryki.FabrykaSkładnikówPizzy;
import FabrykaAbstrakcyjna.Fabryki.WłoskaFabrykaSkładnikówPizzy;
import FabrykaAbstrakcyjna.Pizza.Pizza;
import FabrykaAbstrakcyjna.Pizza.Serowa;

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
