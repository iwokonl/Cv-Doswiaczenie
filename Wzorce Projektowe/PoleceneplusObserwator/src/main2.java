import Pol.Polecenie;
import Pol.PolecenieRejestracji;
import Pol.UżytkownikRejestracja;

import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public class main2 {
    public static void main(String[] args) {
        Polecenie polecenieRejestracja = new PolecenieRejestracji();
        UżytkownikRejestracja użytkownikRejestracja = new UżytkownikRejestracja(polecenieRejestracja);
        AtomicInteger i = new AtomicInteger();
        long startTime = System.nanoTime();
            while (i.get() != 100000000){

                użytkownikRejestracja.wykonajRejestracje();

                i.getAndIncrement();
            }
        long endTime = System.nanoTime();

    }
}
