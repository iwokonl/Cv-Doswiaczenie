import ver2.*;
public class Main2 {
    public static void main(String[] args) {
        Pizzeria włoskaPizzeria = new PizzeriaWłoska();
        Pizza pizza = włoskaPizzeria.zamówPizze();
        System.out.println("Pizza " + pizza.getNazwa() + " gotowa");

        System.out.println();
        System.out.println();
        System.out.println();
        Pizzeria amerykańskaPizzeria = new PizzeriaAmerykańska();
        pizza = amerykańskaPizzeria.zamówPizze();
        System.out.println("Pizza " + pizza.getNazwa() + " gotowa");

    }
}
