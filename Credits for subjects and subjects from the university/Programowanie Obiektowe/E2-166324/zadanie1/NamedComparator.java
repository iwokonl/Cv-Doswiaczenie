package zadanie1;

import java.util.Comparator;

public class NamedComparator implements Comparator<Doktorant> {

    @Override
    public int compare(Doktorant o1, Doktorant o2) {
        Integer temp = 0;
        Integer temp2 = 0;
        for(int i = 0;i<o1.getPoints().size();i++){
            temp += o1.getPoints().get(i);
        }
        for(int i = 0;i<o2.getPoints().size();i++){
            temp2 += o2.getPoints().get(i);
        }
        return temp - temp2;
    }
}
