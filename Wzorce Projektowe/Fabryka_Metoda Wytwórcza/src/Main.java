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
Wzorzec Metoda wytwórcza/Fabryka bazuje na dodaniu elsastyczności i możliwości późniejszej
rozbudowy. Przykład powyższy to pizzeria. Można tutaj dodawać dowolną ilość Pizz dla specyficznej pizzerii.
Polega to na tym że zlecamy tak jakby na początku chęc wykonania Pizzy do Pizzerii(Typ pizzy). następnie pizza
Zostaje zrobiona przez pizzerie włoską.Pizzeria(Zwraca ty Pizza bo tego chcieliśmy żeby pod jednym
typem można dawać wiele rodzajów tej samej pizzy) po otrzymaniu pizzy mamy gotowy element na któryn wiemy jak operować.
Bo zaadoptowaliśmy klasę abtrakcyjne które wymuszają powstanie pewnych motod. Tym samym stworzyliśmy
bardzo elastyczny program do tworzenia pizz.

Wzorzec kreacyjny to mechanizmy tworzenia obiektów, zwiększania elastyczności i ten typ ułatwia ponowne używanie kodu.
Źródła:
https://refactoring.guru/pl/design-patterns/factory-method
Rozdział 4 pierwsza część
https://www.youtube.com/watch?v=EdFq_JIThqM
 */