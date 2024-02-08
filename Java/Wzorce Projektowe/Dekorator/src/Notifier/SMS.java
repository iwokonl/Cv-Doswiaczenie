package Notifier;

public class SMS implements Notifier{
    Notifier notifier;
    public SMS(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send() {

        System.out.println("Wysłano ci SMS");
        notifier.send();

    }
}
