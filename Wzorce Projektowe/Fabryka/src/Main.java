import Pizzeria_ver1.*;
public class Main {
    public static void main(String[] args) {
        Pizzeria wloskaPizza= new PizzeriaWłoska();
        Pizzeria amerykańska = new PizzeriaAmerykańska();
        Pizza pizza = wloskaPizza.zamówPizze("serowa");
        System.out.println("Eryk zamówił: " + pizza.getNazwa() + "\n");
        pizza = amerykańska.zamówPizze("serowa");
        System.out.println("Janek zamówił: " + pizza.getNazwa() + "\n");
    }
}

/*



 */