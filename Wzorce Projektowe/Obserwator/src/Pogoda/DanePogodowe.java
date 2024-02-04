package Pogoda;

import java.util.ArrayList;
import java.util.List;

public class DanePogodowe implements Podmiot_ObiektObserwowany{
    public DanePogodowe(){
        obserwatory = new ArrayList<>();
    }
    float pobierzTemperaturę(){
        return this.temperatura;
    }
    float pobierzWilogtność(){
        return this.wilgotność;
    }
    float pobierzCiśnienie(){
        return this.ciśnienie;
    }

    void zmienionoOdczyt(){
        powiadomObserwator();
    }
    @Override
    public void zarejestrójObserwator(Obserwator o) {
        obserwatory.add(o);
    }

    @Override
    public void usuńObserwator(Obserwator o) {
        obserwatory.remove(o);
    }
    public void ustawOdczyt(float temperatura, float wilgotność, float ciśnienie){
        this.temperatura = temperatura;
        this.wilgotność = wilgotność;
        this.ciśnienie = ciśnienie;
        zmienionoOdczyt();
    }
    @Override
    public void powiadomObserwator() {
        for(Obserwator obserwator:obserwatory){
            obserwator.aktualizacja();
        }
    }

    private List<Obserwator> obserwatory;
    private float temperatura;
    private float wilgotność;
    private float ciśnienie;
}
