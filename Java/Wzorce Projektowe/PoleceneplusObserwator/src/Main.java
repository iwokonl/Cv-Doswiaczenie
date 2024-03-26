import Pol.Polecenie;
import Pol.PolecenieRejestracji;
import Pol.UżytkownikRejestracja;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {


    private static void performCleanup(long duration) {
        System.out.println(duration);
    }
    public static void main(String[] args) {

        Polecenie polecenieRejestracja = new PolecenieRejestracji();
        UżytkownikRejestracja użytkownikRejestracja = new UżytkownikRejestracja(polecenieRejestracja);
        AtomicLong i = new AtomicLong();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        long startTime = System.currentTimeMillis();
        new Thread(() -> {
        while (i.get() != 100000000){

                użytkownikRejestracja.wykonajRejestracje();

            i.getAndIncrement();
        }
        }).start();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            performCleanup(duration);
        }));

    }
}
