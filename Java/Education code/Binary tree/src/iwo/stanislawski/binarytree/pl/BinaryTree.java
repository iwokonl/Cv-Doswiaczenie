package iwo.stanislawski.binarytree.pl;

public class BinaryTree {
    private int value;
    private BinaryTree left_child;
    private BinaryTree right_child;


    public BinaryTree(int value) {
        this.value = value;
        this.left_child = null;
        this.right_child = null;
    }

    public void Insert(int Added_Value) {
        Insert(this, Added_Value);
    }
    public void Change(int Value, int ChangeValue){
        Change(this, Value, ChangeValue);
    }
    public void Change(BinaryTree object ,int Value, int ChangeValue){
        if (object.value == Value & object.left_child == null & object.right_child == null) {
            object.value = ChangeValue;
        }
        else if(Value > object.value){
            Change(object.right_child, Value, ChangeValue);
        }
        else {
            Change(object.left_child, Value, ChangeValue);
        }

    }
    public void Delete(int Value){
        Delete(this, Value);
    }

    public void Delete(BinaryTree object, int Value){
        // If Node is before leaf
        if (Value > object.value) {
            if(object.right_child.value == Value){
                object.right_child = null;
            }
            else{
                Delete(object.right_child, Value);
            }
        }
        else {
            if(object.left_child.value == Value){
                object.left_child = null;
            }
            else{
                Delete(object.left_child, Value);
            }
        }

    }
    @Override
    public String toString() {
        String temp = print(this, 0, "");
        return temp;
    }

    public String print(BinaryTree object, int level, String temp) {
        StringBuilder space = new StringBuilder();
        if (object.right_child != null) {
            temp = print(object.right_child, level + 1, temp);
        }
        for (int i = 0; i < 4 * level; i++) {
            space.append(' ');
        }
        temp += space + "->" + object.value + '\n';
        if (object.left_child != null) {
            temp = print(object.left_child, level + 1, temp);
        }
        return temp;
    }

    private void Insert(BinaryTree object, int Added_Value) {
        if (object.value > Added_Value) {
            if (object.left_child == null) {
                object.left_child = new BinaryTree(Added_Value);
            } else {
                this.Insert(object.left_child, Added_Value);
            }
        } else {
            if (object.right_child == null) {
                object.right_child = new BinaryTree(Added_Value);
            } else {
                this.Insert(object.right_child, Added_Value);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeft_child() {
        return left_child;
    }

    public void setLeft_child(BinaryTree left_child) {
        this.left_child = left_child;
    }

    public BinaryTree getRight_child() {
        return right_child;
    }

    public void setRight_child(BinaryTree right_child) {
        this.right_child = right_child;
    }


}
