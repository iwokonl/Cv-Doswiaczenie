package Notifier;

public class mainb {
    public static void main(String[] args) {
        Notifier Franek = new Obiektdekorowany();
        Franek = new FB(Franek);
        Franek = new SMS(Franek);
        Franek.send();

    }
}
