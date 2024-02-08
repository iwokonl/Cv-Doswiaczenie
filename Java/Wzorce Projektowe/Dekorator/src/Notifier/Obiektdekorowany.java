package Notifier;

public class Obiektdekorowany implements Notifier{



    @Override
    public void send() {
        System.out.println("Zakończono wysyłanie wiadomości");
    }
}
