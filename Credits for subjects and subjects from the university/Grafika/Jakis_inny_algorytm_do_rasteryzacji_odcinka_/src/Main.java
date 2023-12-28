public class Main {
    public static void main(String[] args) {
        int i1 = 0;
        int i2 = 3;
        int j1 = 0;
        int j2 = 1;
        double m = (double) (j2 - j1) /(i2-i1);
        double b = 0;
        int j = j1;
        System.out.println("writePixel(" + i1 + ", " + j1 + ")");
        for(int i = i1+1;i<=i2;i++){
            b = b+m;
            if(b>((double) 1 /2)){
                j = j+1;
                b = b-1;
            }
            System.out.println("("+i+","+j+")");
        }
    }
}