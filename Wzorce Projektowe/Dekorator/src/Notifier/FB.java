package Notifier;

public class FB implements Notifier{
    Notifier notifier;
    public FB(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send() {
       // notifier.send();
        System.out.println("Wysłano do fb");//jeśli to tutaj by było to automatycznie przejdzie do kolejnego zapakowanego obiektu i zrobi to na końcu
        notifier.send();
    }
}
