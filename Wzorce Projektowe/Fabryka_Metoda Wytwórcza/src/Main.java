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
bardzo elastyczny program do tworzenia pizz. Pamiętamy przy tym że chcemy do klasy abstrakcyjnej lub interfejsu umieścić rzeczy zmienne
(chcemy odizolować zmienne od rzeczy stałych(hermetyzacja)(Klas produktów)). Po stworzeniu Klas wytwórców(Fabryki). Nie naruszamy zasad SOLID czyli pojedyńczej odpowiedzialności
obiektu.

Zastosowanie:
- Stosujemy wtedy kiedy nie do końca wiemy jakie produkty będą zwracane a wiemy jaka rodzina poruktów będzie zwracana i
jakie między nimi będą zależności

Zasady:
- DIY (wytłumaczone w "Fabryka abstrakcyjna")
- OCP(open/close) jedna z kolejnych zasad SOLID która mówi o tym że element oprogramowania powinien być otwarty na rozbudowę,
ale zamknięty na modyfikację. Oznacza to, że powinniśmy być w stanie dodawać nowe funkcjonalności bez zmieniania istniejącego kodu.
To znaczy: trochę skalowalności brak zmian w milionach miejsc np. robisz interfejs o cenie do pizzy i robisz kilka klass pizz
Margherita, Pepperoni i z ananasem. Jeśli zrobisz to na zasadzie jak w pakiecie FolderPokazowy


Wzorzec kreacyjny to mechanizmy tworzenia obiektów, zwiększania elastyczności i ten typ ułatwia ponowne używanie kodu.
Źródła:
https://refactoring.guru/pl/design-patterns/factory-method
Rozdział 4 pierwsza część
https://www.youtube.com/watch?v=EdFq_JIThqM
 */