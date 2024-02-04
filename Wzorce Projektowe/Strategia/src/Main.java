import Gra.Król;
import Gra.Postać;
import Gra.ŁukiStrzałyZachowanie;

public class Main {
    public static void main(String[] args) {
        Postać postać = new Król();
        postać.użyjBroni();
        postać.walcz();

        postać.ustawBroń(new ŁukiStrzałyZachowanie());
        postać.użyjBroni();
    }
}