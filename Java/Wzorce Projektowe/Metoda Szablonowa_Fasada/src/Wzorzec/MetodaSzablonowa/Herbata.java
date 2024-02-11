package Wzorzec.MetodaSzablonowa;

public class Herbata extends NapójZKofeinąCośOgólnego{

    @Override
    void zaparzanie() {
        System.out.println("wlewanie wody do kubka z herbatą ");
    }

    @Override
    void dodanieSkładników() {
        System.out.println("Dodanie cukru.");
    }
}
