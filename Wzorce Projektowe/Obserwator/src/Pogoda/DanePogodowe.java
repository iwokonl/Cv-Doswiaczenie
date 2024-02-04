package Pogoda;

import java.util.ArrayList;
import java.util.List;

public class DanePogodowe implements Podmiot_ObiektObserwowany{
    public DanePogodowe(){
        obserwatory = new ArrayList<>();
    }
    void pobierzTemperaturę(){

    }
    void pobierzWilogtność(){

    }
    void pobierzCiśnienie(){

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
            obserwator.aktualizacja(temperatura,wilgotność,ciśnienie);
        }
    }

    private List<Obserwator> obserwatory;
    private float temperatura;
    private float wilgotność;
    private float ciśnienie;
}
