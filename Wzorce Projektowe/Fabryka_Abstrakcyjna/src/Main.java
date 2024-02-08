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
/*
DIP - Nakłada nacisk na tworzenie składników abstrakcyjnych. Mówi że składniki wysokiego poziomu nie powinny być uzależnione
od składników niskiego poziomu. Znaczy to co innego że abstrakcja tworzy pewną bierierę miedzy tymi składnikami i ma za zadanie
odzielać poziomy.
Reguły:
Żadna zmienna nie powinna przechowywać odwołania do klasy rzeczywistej
Żadna klasa nie powinna dziedziczyć po klasie rzeczywsitej
Żadna metoda nie ppowinna przesłaniać metody zaimplementowanej w dowolnej z klas bazowych.
"powinna" - czasami się nie da i trzeba wykonać pewne implementacje. Tak samo jak fabryka jest to wzorzec kreacyjny.


Wzorzec Fabryka abstrakcyjna jest "przedłużeniem" wzorca metoda wytwórcza/Fabryka. Zawiara się w nim jedna z zasad SOLID
(DIP - Dependency Inversion Principle). Definicja wzorca to dostarczanie interfejsu do tworzenia całych rodzin powiązanych
ze sobą lub zależnych od siebie obiektów bez konieczności określania ich klasy rzeczywistej. Wzorzec wymusza grupowanie
ze sobą powiązanych produktów.
 */