import Gra.Król;
import Gra.Postać;
import Gra.ŁukiStrzałyZachowanie;

public class Main {
    public static void main(String[] args) {
        Postać postać = new Król();
        postać.użyjBroni();
        postać.walcz();

        postać.ustawBroń(new ŁukiStrzałyZachowanie());
        postać.użyjBroni();
    }
}

/*
Według mnie rozwiązanie to można stosować kiedy wiemy lub przypuszczamy, że pojawią się jakieś nowe funkcjonalności i opcje
np. mamy zrobić aplikacje do zamawiania jedzienie i w niej na początku bo jest brak terminala online dodajemy odbiór
na miejscui na wynos. Wiedzieliśmy tylko o terminalu więc mamy szanse go dodać, ale właściciel restauracji kazał nam dodać
opcje na dowóz, więc mamy krytą dupe. Działa to tak, że mamy coś całego np klasę Jedzenie odbiór tworzymy ją w taki sposób
aby w trakcie działania programu można było zmienić sposób dostawy(funkcjonalność obiektu) np.(Wyjaśnienie sposobu działania)
użytkownik chce zrobić sobie zamówienie no to klasa główna to "Zamówienie" dodajemy interfejs
ZamówienieZachowanie(interfejs wymusza na nas implementacje metod ale jest bardziej
elastyczny niż klasa abstrakcyjna/metoda abstrakcyjna.) Następnie robimy sobie DostawaZachowanie, OdbiórZachowanie(jako klasy) i dodajemy klase
"Odbiór" zgodnie z schematem w tym projekcie. Więc jeden obiekt Zamówienie może dynamicznie przyjąć różną formę podczas działania.
Dodatkowo nie przejmujemy się typem tylko wszędzie możemy walić instancje obiektu zamówienie i wiemy że to się dostosuje.
Sama logika klasy oddelegowuje powierzone jej zadania do innych metod więc tym samym jest elastyczna. Ma to swoje plusy przy
samym tworzeniu wyobraź sobie, że najebiałeś jak pojeb wszędzie if'y i cały twój kod mieści się w jednym pliku gdzie
jest 1000 linijek niby fajnie, ale w zespole nie robisz sam i jak ktoś ma pracować nad projektem kiedy ty pushujesz zmiany chłop pushuje
zmiany i koniec końców jest to robota głupiego bo zmiany któregoś zostaną usunięte, a tak to rzeczy zmienne wrzucasz do Hermetycznych zachowań/strategii i
każdy robi co ma zrobić oraz nie przeszkadzają sobie w pracy. Sposób kompozycji usuwa wady dziedziczenia i pomaga nam zapanować nad programem.
Jest to wzorzec bechawioralny. Tego typu wzorce tyczą się algorytmów i dzielą odpowiedzialność na obiekty.
Materiały:
Książka wyd. II rozdział I, Wzorce projektowe rusz głową.
https://refactoring.guru/pl/design-patterns/strategy
https://www.youtube.com/watch?v=Nrwj3gZiuJU
*/