import ver1.*;
import ver2.*;

public class Main {
    public static void main(String[] args) {
        Napój napój = new Espressso();
        System.out.println(napój.pobierzOpis()
                + " " + napój.koszt() + " zł.");


        Napój napój2 = new Special();
        napój2 = new Czekolada(napój2);
        napój2 = new Czekolada(napój2);

        System.out.println(napój2.pobierzOpis()
                + " " + (napój2.koszt()) + " zł.");


//    //////////////////////////////////////////////////////////////////////////////

        NapójInterfejs napójver2 = new Espresso();
        System.out.println(napójver2.opis() + " " + napójver2.cena());
        System.out.println();

        napójver2 = new Czekolada2(napójver2);
        System.out.println(napójver2.opis() + " " + napójver2.cena());
    }




}

/*
Zasada działania jest taka że mamy jaki typ główny np. napój chcemy zamówić kawę, więc kawa dziedziczy po napoju. Chcemy dodać do kawy czekoladę, więc opakowujemy kawę w czekoladę i tak samo robimy z śmietaną którą
chcemy też dodać do tej kawy.(Wszystkie te obiekty muszą odzwierciedlać siebie czyli być tego samego typu/dziedziczą po napoju). Jeśli chcemy co kolwiek zrobić to musimy rozpakować tą matripszkę
podąrzamy od najbardziej zewnętrznej cześci do zewnętrznej. Jeśli chcemy obliczyć koszt to na każdym obiekcie wywołujemy koszt w takiej kolejnoci BitaŚmietana -> Czekolada -> Kawa i natępnie jest
to wsszystko zwracane w kolejności Kawa -> Czekolada -> Bitamietana w tedy otrzymujemy koszt zakupu tak zrobionej kawy. Podsumowanie: Obiekty dekorujące są tego samego typu co obiekty dekorowane,
Jeden obiek dekorowany może zostać opakowany w jeden lub więcej dekoratorów. Jeśli dekorator jest takiego samego typu co obiekt dekorowany to możemy przekazać cały taki zawinięty obiekt zamiast wszystkich odzielnie.
Dekorator dodaje swoje własne zachowania przed delegowaniem do obiektu dekorowanego właściwego zadania i(lub) po nim(?). Obiekty mogą być
dekorowane w dowolnym momencie, czyli możemy je również dekorować dynamicznie podczas działania programu, używając dowolnej liczby
dekoratorów. W wielkim skrócie dekorator pozwala na dynamiczne dodawanie nowych zachowań do obiektu.
Sposób działania:
    Wersja dla klasy abstrakcyjnej:
    - Tworzymy obiekty
    -
    -
    -
    -
    -
    -

    Wersja dla interfejsu:
    - Tworzymy interfejs który jest jednolity dla wszystkich dekoratorów i tego w co będziemy opakowywali ten dekorator.
    - Tworzymy źródło czyli to co będziemy opakowywać bez konstruktora
    - Tworzymy dodatki do tego co wyżej z konstruktorem oraz polem klasy który jest typem interfejsu, i odwołujemy się do niego
co załatwia nam problem nie tego typu co trzeba
    - Po stworzeniu tego co wyżej typujemy to interfejsem i tworzymy to co chemy opakować
    - Potem opaowujemy to wsadzając jako argument rzecz opakowywaną
 */

/*
Dziedziczenia używamy tylko i wyłącznie aby występowała zgodność typów
 */