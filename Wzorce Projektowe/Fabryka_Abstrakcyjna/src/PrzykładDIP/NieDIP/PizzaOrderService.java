package PrzykładDIP.NieDIP;

class PizzaOrderService {
    void orderPizza(String type) {
        if (type.equals("Margherita")) {
            MargheritaPizza pizza = new MargheritaPizza();
            pizza.preparePizza();
        }
        // dla każdego nowego typu pizzy, musimy zmodyfikować tę metodę
    }
}
