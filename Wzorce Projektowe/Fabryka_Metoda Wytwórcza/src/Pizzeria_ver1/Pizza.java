package Pizzeria_ver1;

import java.util.ArrayList;

public class Pizza {
    String ciasto;
    String nazwa;
    String sos;
    ArrayList<String> dodatki = new ArrayList<>();

    void przygotowanie() {
        System.out.println("Przygotowanie pizzy: " + nazwa);
        System.out.println("Wybranie ciast ....");
        System.out.println("Dodanie sosu...");
        System.out.println("Dodatki: ");
        for (String dodatek : dodatki) {
            System.out.println("   " + dodatek);
        }
    }

    void pieczenie() {
        System.out.println("Pieczenie: 25 minut w temperaturze 180 stopni Celsjusza.");
    }

    void krojenie() {
        System.out.println();
    }

    void pakowanie() {
        System.out.println();
    }



    public String getNazwa(){
        return nazwa;
    }


}
