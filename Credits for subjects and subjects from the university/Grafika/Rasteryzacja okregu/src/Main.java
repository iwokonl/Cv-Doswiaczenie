public class Main {
    public static void main(String[] args) {
        double r = 18; // radius
        int i = 0; // x-axis
        int j = 18; // y-axis
        double f = 5 - 4*r;
        System.out.print("i = " + i + ", j = " + j + ", f = " + f + " ");
        System.out.println("x = " + i + ", y = " + (Math.sqrt(Math.pow(r,2))- Math.sqrt(Math.pow(i,2))) + ", f = " + f);
        while (i < j) {
            if (f > 0) {
                j = j - 1;
                f = f + 8*i - 8*j + 20;
            }
            else {
                f = f + 8*i + 12;
            }
            i = i + 1;
            System.out.print("i = " + i + ", j = " + j + ", f = " + f+ " ");
            System.out.println("x = " + i + ", y = " + (Math.sqrt(Math.pow(r,2)-Math.pow(i,2))) + ", f = " + f);
        }
    }
}
311,25
