package Pogoda;

public interface Podmiot_ObiektObserwowany {
    void zarejestrójObserwator(Obserwator o);
    void usuńObserwator(Obserwator o);
    void powiadomObserwator();
}
