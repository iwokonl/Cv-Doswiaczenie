package Fabryka;

public abstract class FabrykaFoteli {

    public Fotel zamówFotel(String type){
        Fotel fotel = utwórzFotel(type);

        fotel.skręćFotel();
        fotel.pakowanieFotela();
        fotel.wysyłanieFotela();
        System.out.println(fotel.skręćFotel() + fotel.pakowanieFotela() + fotel.wysyłanieFotela());
        return fotel;
    }
    public abstract Fotel utwórzFotel(String type);
}
