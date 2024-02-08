import Pogoda.*;

public class Main {
    public static void main(String[] args) {
        DanePogodowe danePogodowe = new DanePogodowe();

        WarunkiBieżące warunkiBieżące = new WarunkiBieżące(danePogodowe);
        StatystykaPanel statystykaPanel = new StatystykaPanel(danePogodowe);

        danePogodowe.ustawOdczyt(26.6f,0.05f,1000.24f);
        System.out.println("");
        danePogodowe.ustawOdczyt(5f,0.05f,1000.24f);
        System.out.println("");
        danePogodowe.ustawOdczyt(4f,0.05f,1000.24f);
        System.out.println("");
        danePogodowe.usuńObserwator(statystykaPanel);
        System.out.println("");
        danePogodowe.powiadomObserwator();
    }
}

/*
W skrócie ten wzorzec składa się z oberwatora i obiektu obserwowanego(Podmiot, obiekt obserwowany).
Zasada jest taka że obiekty obserwujące nasłuchują co ma im do powiedzenia podmiot. Więc tworzymy klasę podmiotu w tym wypadku to klasa DanePogodowe, do tej klasy
tworzymy interfejs który musi mieć takie metody jak: (ponieważ jest to wymagane dla obiektu który wysyła informacje) usuńObserwatora, dodajObserwatora i powiadomObserwatory.
Następnie tworzymy odbiorców/nasłuchujących PrognozaPanel, StatystykaPanel, WarunkiBieżące. Sytuacja jest analogiczna jak dajesz followa albo serduszko komuś na instagramie. Jest podmiot
czyli instagram do którego wysyłąsz informacje "siema dałem follow'a/serduszko" Potem po tej informacji podmiot wysyła informacje do interesariusza czyli do konta któremu się wykonało taką akcje.
Jest to relacja jeden do wielu(1:N) i jest to wzorzec. Wzorzec behawioralny. Jeśli implemetujesz ten wzorzec postaraj się żeby był na tyle elastyczny w interfejsie(metoda aktualizacja nie przyjmowała
żadnych argumentó ponieważ będziesz musiał zmieniać to w wszystkich plikach, interfejsie itd. zamiast tego zrób gettery i settery i w danej klasie nasłuchującej w metodzie aktualizacja dodaj getTemeratura np.).
Prawdopodobnie może się to sprawdzać w wiadomościach push, kiedy są braki na magazynie itd. Staraj się też luźno łączyć wszsystko aby było skalowalne i wymienialne.
 */