// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double i1 = (double) 1 /18;
        double i2 = 7/16;
        double j1 = (double) 1 /18;
        double j2 = (double) 3 /15;
        double b = 0;
        double m = 2 * (j2 - j1);
        System.out.println("writePixel(" + i1 + ", " + j1 + ")");
        double j = j1;
        double P = i2 - i1;
        for (double i = i1 + 1; i <= i2; i++) {
            b = b + m;
            if (b > P) {
                j = j + 1;
                b = b - 2 * P;
            }
            System.out.println("writePixel(" + i + ", " + j + ")");
        }
    }
}
