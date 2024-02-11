package Wzorzec.MetodaSzablonowa;

public class Kawa extends NapójZKofeinąCośOgólnego {
    @Override
    void zaparzanie() {
        System.out.println("wlewanie wody do kawy rozpuszczalnej ");
    }

    @Override
    void dodanieSkładników() {
        System.out.println("Dodanie słodzika i mleka");
    }
}
