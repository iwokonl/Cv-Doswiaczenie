package Wzorzec.MetodaSzablonowa;

public abstract class NapójZKofeinąCośOgólnego {
    public final void recepturaPrzygotowania(){ // Final w tym przypadku zapobiega przesłanianiu.
        gotowanieWody();
        zaparzanie();
        nalewaniedoFiliżanki();
        dodanieSkładników();
    }
    abstract void zaparzanie();
    abstract  void dodanieSkładników();


    void gotowanieWody(){
        System.out.println("Przygotowywanie wody");
    }

    void nalewaniedoFiliżanki(){
        System.out.println("Nalewanie do filiżanki");
    }
}
/*
Klasa ta ma za zadanie ogólnie opisać jakieś algorytmy nie wnikając w ich logikę.
Wywołuje ona po kolei odpowiednie metody. Metody które są ogólne i które można zastosować
do wszystkich z podklas umieszczamy tutaj jeśli jakiś algorytm wymaga doprecyzowania przez własną
implementacje umieszczamy go tutaj.

Jak widać metoda zaparzanie i dodanieSkładników jest implementowane już przez składnik niskiego poziomu(Kawa/Herbata).
A metody gotowanieWody i nalewanieWody są na tyle ogólne i okuratne że pasują do każdego kontekstu z składników niskiego poziomu.

 */