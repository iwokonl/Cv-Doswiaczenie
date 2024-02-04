package Pogoda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StatystykaPanel implements Obserwator, PanelObserwacyjny{
    public StatystykaPanel(DanePogodowe o){
        historiaTemperatury = new ArrayList<>();
        this.danePogodowe = o;
        danePogodowe.zarejestrójObserwator(this);
    }
    @Override
    public void aktualizacja(float temp, float wilgotność, float ciśnienie) {
        historiaTemperatury.add(temp);
        wyświetl();
    }


    private float temperatura;
    private ArrayList<Float> historiaTemperatury;
    private DanePogodowe danePogodowe;

    @Override
    public void wyświetl() {
        System.out.println("Temperatura średnia / maksymalna / minimalna " +
                historiaTemperatury.stream().mapToDouble(d -> d).average().orElse(0.0) +" / "+
                Collections.max(historiaTemperatury) + " / " + Collections.min(historiaTemperatury));
    }
}
