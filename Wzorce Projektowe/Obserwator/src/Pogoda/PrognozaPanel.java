package Pogoda;

public class PrognozaPanel implements PanelObserwacyjny, Obserwator{
    @Override
    public void wyświetl() {
        System.out.print("Pogoda się utrzyma ");
    }

    @Override
    public void aktualizacja() {
        wyświetl();
    }
}
