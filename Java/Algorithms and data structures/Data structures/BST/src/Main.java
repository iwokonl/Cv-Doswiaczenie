import pl.stanislawski.iwo.BST;

public class Main {
    public static void main(String[] args) {
        BST temp = new BST(5);
        temp.insert(3);
        temp.insert(7);
        temp.insert(2);
        temp.insert(4);
        temp.insert(6);
        temp.insert(8);
        System.out.println(temp.toString());

    }
}