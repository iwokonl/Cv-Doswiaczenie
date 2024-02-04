import Pogoda.*;

public class Main {
    public static void main(String[] args) {
        DanePogodowe danePogodowe = new DanePogodowe();

        WarunkiBierzące warunkiBierzące = new WarunkiBierzące(danePogodowe);
        StatystykaPanel statystykaPanel = new StatystykaPanel(danePogodowe);

        danePogodowe.ustawOdczyt(26.6f,0.05f,1000.24f);
        danePogodowe.ustawOdczyt(5f,0.05f,1000.24f);
        danePogodowe.ustawOdczyt(4f,0.05f,1000.24f);

    }
}

/*
Rysunek do zobrazowania sobie tego będzie załączony  w zip'ie. W skrócie ten wzorzec składa się z oberwatora i obiektu obserwowanego(Podmiot, obiekt obserwowany).
Zasada jest taka że obiekty obserwujące nasłuchują co ma im do powiedzenia podmiot. Więc tworzymy klasę podmiotu w tym wypadku to klasa DanePogodowe, do tej klasy
tworzymy interfejs który musi mieć takie metody jak: (ponieważ jest to wymagane dla obiektu który wysyła informacje) usuńObserwatora, dodajObserwatora i powiadomObserwatory.
Następnie tworzymy odbiorców/nasłuchujących PrognozaPanel, StatystykaPanel, WarunkiBierzące.
 */