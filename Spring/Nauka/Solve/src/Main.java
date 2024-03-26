import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {
    public int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else {

            // Compute  height of each subtree
            int lheight = height(root.left);
            int rheight = height(root.right);

            // use the larger one
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
    public void printLevelOrder(TreeNode root, ArrayList<Object> arrayList)
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i, arrayList, "");
    }

    public void printCurrentLevel(TreeNode root, int level, ArrayList<Object> arrayList, String s)
    {
        if(s.equals("left") && root == null)
            arrayList.add("null");
        if (root == null)
            return;
        if (level == 1) {
            arrayList.add(root.val);
            arrayList.add(s);
        }
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1, arrayList, "left");
            printCurrentLevel(root.right, level - 1, arrayList, "right");
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Object> arrayListP = new ArrayList<>();
        ArrayList<Object> arrayListQ = new ArrayList<>();
        printLevelOrder(p, arrayListP);
        printLevelOrder(q, arrayListQ);

    }
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Object> arrayListP = new ArrayList<>();
        ArrayList<Object> arrayListQ = new ArrayList<>();
        printLevelOrder(root.left, arrayListP);
        printLevelOrder(root.right, arrayListQ);
        return arrayListP.equals(arrayListQ);
    }
    public static void main(String[] args) {
        String[] array = {"ac","aacb"};
        String result = new Main().longestCommonPrefix(array);
    }
}