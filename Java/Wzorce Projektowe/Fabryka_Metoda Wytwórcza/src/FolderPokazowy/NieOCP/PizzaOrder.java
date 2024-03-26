package FolderPokazowy.NieOCP;

public class PizzaOrder {
    public double cenaPizzy(String pizzaType){
        if(pizzaType.toLowerCase().equals("pepperoni"))
            return 5.0;
        else if (pizzaType.toLowerCase().equals("małż")) {
            return 2222.0;
        }
        return 0.0;

    }
}

/*
// Za każdym razem, gdy chcemy dodać nowy rodzaj pizzy, musimy modyfikować tę metodę.
 */