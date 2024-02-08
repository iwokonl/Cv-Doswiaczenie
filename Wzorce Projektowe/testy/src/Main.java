import Dekorator.BrugerNormalny;
import Dekorator.BurgerInterfejs;
import Dekorator.KotletZMięsem;
import Dekorator.Sałata;
import Strategia.Koła17Cali;
import Strategia.Motor;
import Strategia.Pojazd;
import Strategia.Rower;

public class Main {
    public static void main(String[] args) {

        // Strategia
        Pojazd pojazd = new Motor();
        pojazd.jakiPojazd();
        pojazd.zmieńKoła(new Koła17Cali());
        pojazd.jakiPojazd();

        // Dekorator

        BurgerInterfejs burger = new BrugerNormalny();
        burger = new KotletZMięsem(burger);
        burger = new Sałata(burger);
        System.out.println(burger.opis() +" " + burger.cena());



    }
}