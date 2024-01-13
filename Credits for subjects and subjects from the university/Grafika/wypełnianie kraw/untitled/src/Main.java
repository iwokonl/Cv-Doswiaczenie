import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<int[]> kraw = new ArrayList<>();
        kraw.add(new int[]{3, -1,0,0});
        kraw.add(new int[]{3, -1,6,0});
        kraw.add(new int[]{0,0,1,3});
        kraw.add(new int[]{6,0,4,3});
        kraw.add(new int[]{1,3,2,2});
        kraw.add(new int[]{4,3,2,2});
        int y = -1;
        ArrayList<int[]> aktytab = new ArrayList<>();
        while(aktytab.isEmpty()){
            for (int i = 0; i < kraw.size(); i++) {
                if (kraw.get(i)[1] == y) {
                    aktytab.add(kraw.get(i));
                    
                    kraw.remove(i);
                }
            }
        }

    }
}