import iwo.stanislawski.binarytree.pl.BinaryTree;
public class Main {
    public static void main(String[] args) {
        BinaryTree temp = new BinaryTree(1);
        temp.Insert(2);
        temp.Insert(3);
        temp.Insert(-1);


        temp.Delete(3);
        System.out.printf(temp.toString());
    }
}