package FolderPokazowy.OCP;

public class main {
    public static void main(String[] args) {
        Pizza małż = new MałżPizza();
        PizzaOrder pizzaOrder = new PizzaOrder();
        System.out.println(pizzaOrder.pizzaPrice(małż));
        Pizza vege = new VegePizza();
        System.out.println(pizzaOrder.pizzaPrice(vege));
    }
}
