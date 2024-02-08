import Polecenie.Pilot;
import Polecenie.Polecenie.PolecenieWywołajŚwiatło;
import Polecenie.Światło;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pilot pilot = new Pilot();
        Światło światło = new Światło();
        PolecenieWywołajŚwiatło polecenieWywołajŚwiatło = new PolecenieWywołajŚwiatło(światło);
        Scanner scanner = new Scanner(System.in);

        pilot.ustawPolecenie(polecenieWywołajŚwiatło);
        while (true){

            System.out.println("1. włącz/wyłącz światło");
            System.out.println("2. Koniec");
            String key = scanner.nextLine();

            if(key.toLowerCase().equals("1")){
                pilot.przyciskZostałNaciśnięty();
                if(pilot.getState()){
                    System.out.println("Światło włączone");
                    System.out.println();
                }
                else {
                    System.out.println("Światło wyłączone");
                    System.out.println();
                }
            } else if (key.toLowerCase().equals("2")) {
                break;
            }
            else {
                System.out.println("Zły przycisk");
            }
        }
    }
}

/*
Wzorca używyamy w przypadku kiedy program ma wysłać informacje o wykonaniu jakiejś czynności np zapisz dodaj(przycisk robi to i tamto).
Działanie Klient -> przekazanie polecenia -> wykonanie w odpowiedniej kolejności. Schemat jest taki że do poleceń robimy
interfejs, polecenie używają interfejsu, Dodajemy odbiornik i coś co wyśle polecenie. W interfejsie obowiązkowo musi być
Wykonanie polecenie. W klasie używającej interfejsu musi być odbiornik umieszczony w konstruktorze. W odbiorniku umieszczamy logikę.
W nadajniku jako pole klasy ustawiamy interfejs tworzymy metody przypisania polecenia oraz wykonania polecenia.
Pilot - Invoker/Sender
PolecenieWywołajŚwiatło - ConcrateComand
Światło - Reciver

 */