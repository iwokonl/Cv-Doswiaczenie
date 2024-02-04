package Pogoda;

public class WarunkiBierzące implements PanelObserwacyjny, Obserwator{
    private float temperatura;
    private float wilgotność;
    private DanePogodowe danePogodowe;
    public WarunkiBierzące(DanePogodowe danePogodowe){
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrójObserwator(this);
    }
    @Override
    public void aktualizacja(float temp, float wilgotność, float ciśnienie) {
        this.temperatura = temp;
        this.wilgotność = wilgotność;
        wyświetl();
    }

    @Override
    public void wyświetl() {
        System.out.println("Warunki bieżące: " + temperatura + "stopni  C oraz " + wilgotność + "% wilgotność");
    }
}
