package Fabryka;

public class Fotel {
    String nazwaFotela;
    String typDrewna;
    String kolorFotela;

    public String skręćFotel(){
        return "Skręcanie fotelu: " + this.nazwaFotela + ", " +this.kolorFotela + ", " + this.typDrewna;
    }
    public String pakowanieFotela(){
        return "Spokowano fotel";
    }

    public String wysyłanieFotela(){
        return "Wysłanie fotela";
    }


}
