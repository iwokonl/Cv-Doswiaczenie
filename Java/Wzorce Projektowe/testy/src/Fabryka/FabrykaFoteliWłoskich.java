package Fabryka;

public class FabrykaFoteliWłoskich extends FabrykaFoteli{
    @Override
    public Fotel utwórzFotel(String type) {
        if("duży".equals(type.toLowerCase())){
            return new FotelWłoskiDuży();
        } else if ("mały".equals(type.toLowerCase())) {
            return new FotelWłoskiMały();
        }
        return null;
    }
}
