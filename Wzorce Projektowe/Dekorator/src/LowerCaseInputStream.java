import java.io.*;

public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        Dekorator - zamykanie obiektu w inne obiekty)
        try (InputStream in = new LowerCaseInputStream(
                new BufferedInputStream(
                        new FileInputStream("D:\\github\\Cv-Doswiaczenie\\Wzorce Projektowe\\Dekorator\\src\\test.txt")))) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}