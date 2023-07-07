package zadanie1;

import java.util.ArrayList;

public class MainDoktorantDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Doktorant> temp = new ArrayList<>();
        ArrayList<Integer> pkt = new ArrayList<>();
        ArrayList<Integer> pkt2 = new ArrayList<>();
        pkt.add(1);
        pkt.add(1);
        pkt.add(11);
        pkt.add(1);
        pkt.add(1);
        pkt.add(1);
        pkt2.add(1);
        pkt2.add(1111);
        pkt2.add(11);
        pkt2.add(1);
        pkt2.add(1);
        pkt2.add(1);
        pkt2.sort(null);
        Doktorant tempp = new Doktorant("i" , 1,pkt);
        Doktorant tempp2 = tempp.clone();

        temp.add(new Doktorant("i",2,pkt));
        temp.add(new Doktorant("i",2,pkt));
        temp.add(new Doktorant("i",2,pkt));
        temp.add(new Doktorant("i",1,pkt2));
        temp.add(new Doktorant("i",2,pkt));
        temp.add(new Doktorant("i",2,pkt));
        temp.add(new Doktorant("i",1,pkt2));
        temp.sort(new NamedComparator());
        temp.sort(null);
        for(int i = 0;i<temp.size();i++){
            System.out.print(temp.get(i).toString()+'\n');
        }
    }
}
