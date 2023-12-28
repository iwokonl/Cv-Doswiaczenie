// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int i1 = 0;
        int i2 = 3;
        int j1 = 0;
        int j2 = 1;
        int b = 0;
        int m = 2 * (j2 - j1);
        System.out.println("writePixel(" + i1 + ", " + j1 + ")");
        int j = j1;
        int P = i2 - i1;
        for (int i = i1 + 1; i <= i2; i++) {
            b = b + m;
            if (b > P) {
                j = j + 1;
                b = b - 2 * P;
            }
            System.out.println("writePixel(" + i + ", " + j + ")");
        }
    }
}
