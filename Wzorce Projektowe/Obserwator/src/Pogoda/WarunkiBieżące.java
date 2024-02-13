package Pogoda;

public class WarunkiBieżące implements PanelObserwacyjny, Obserwator{
    private float temperatura;
    private float wilgotność;
    private DanePogodowe danePogodowe;
    public WarunkiBieżące(DanePogodowe danePogodowe){
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrójObserwator(this);
    }
    @Override
    public void aktualizacja() {
        this.temperatura = danePogodowe.pobierzTemperaturę();
        this.wilgotność = danePogodowe.pobierzWilogtność();
        wyświetl();
    }

    @Override
    public void wyświetl() {
        System.out.println("Warunki bieżące: " + temperatura + "stopni  C oraz " + wilgotność + "% wilgotność");
    }
}
