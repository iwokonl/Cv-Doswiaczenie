public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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
dekoratorów.

 */