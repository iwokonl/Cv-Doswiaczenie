package iwo.stanislawski.binarytree.pl;

import java.util.Objects;

public class BinaryTree {
    private int value;
    private BinaryTree left_child;
    private BinaryTree right_child;


    public BinaryTree(int value) {
        this.value = value;
        this.left_child = null;
        this.right_child = null;
    }

    public void insert(int Added_Value) {
        insert(this, Added_Value);
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

    public void delete(int Value){
        delete(this, Value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTree that)) return false;
        return getValue() == that.getValue() && Objects.equals(getLeft_child(), that.getLeft_child()) && Objects.equals(getRight_child(), that.getRight_child());
    }

    private BinaryTree min_root(BinaryTree object){
        if(object.right_child.left_child == null && object.right_child.right_child == null){
            return object;
        }
        BinaryTree min_root = min_root(object.right_child);
        return min_root;
    }

    private BinaryTree min_right(BinaryTree object){
        if(object.left_child == null && object.right_child == null){
            return object;
        }
        BinaryTree min_right = min_right(object.right_child);

        return min_right;
    }

    private BinaryTree min_left(BinaryTree object){
        if(object.left_child == null && object.right_child == null){
            return object;
        }
        BinaryTree min_left = min_left(object.right_child);
        return min_left;
    }

private void delete(BinaryTree object, int Value){
        if(object.value == Value){
            int temp = min_root(object.right_child).right_child.value;
            delete(object, temp);
            object.value = temp;
            return;
        }
        if (Value > object.value) {
            if(object.right_child.value == Value){
                if(object.right_child.left_child == null && object.right_child.right_child != null){
                    object.right_child = object.right_child.right_child;
                    return;
                } else if (object.right_child.left_child != null && object.right_child.right_child == null) {
                    object.right_child = object.right_child.left_child;
                    return;
                } else if (object.right_child.left_child != null && object.right_child.right_child != null) {
                    if(!(min_left(object.right_child).equals(object.right_child.left_child))){
                        BinaryTree temp_left = object.right_child.left_child;
                        BinaryTree temp_right = object.right_child.right_child;
                        object.right_child = min_right(object.right_child);
                        object.right_child.left_child = temp_left;
                        temp_right.right_child = null;
                        object.right_child.right_child = temp_right;
                        return;
                    }
                    else {
                        BinaryTree temp_left = object.right_child.left_child;
                        object.right_child = min_left(object.left_child);
                        object.right_child.left_child = temp_left;
                        return;
                    }
                } else if (object.right_child.left_child == null && object.right_child.right_child == null) {
                    object.right_child = null;
                    return;
                }
                return;
            }
            else{
                delete(object.right_child, Value);
                return;
            }
        }
        else {
            if(object.left_child.value == Value){
                if(object.left_child.left_child == null && object.left_child.right_child != null){
                    object.left_child = object.left_child.right_child;
                    return;
                } else if (object.left_child.left_child != null && object.left_child.right_child == null) {
                    object.left_child = object.left_child.left_child;
                    return;
                }
                else if (object.left_child.left_child != null && object.left_child.right_child != null) {

                    if(!(min_left(object.left_child).equals(object.left_child.right_child))){
                        BinaryTree temp_left = object.left_child.left_child;
                        BinaryTree temp_right = object.left_child.right_child;
                        object.left_child = min_left(object.left_child);
                        object.left_child.left_child = temp_left;
                        temp_right.right_child = null;
                        object.left_child.right_child = temp_right;
                        return;
                    }
                    else {
                        BinaryTree temp_left = object.left_child.left_child;
                        object.left_child = min_left(object.left_child);
                        object.left_child.left_child = temp_left;
                        return;
                    }
                }
                return;
            }
            else{
                delete(object.left_child, Value);
            }
        }
    }

    public boolean search(int Value){
        return search(this, Value);
    }

    private boolean search(BinaryTree object, int Value){
        if(Value > object.value & object.right_child != null){
            return search(object.right_child,Value);
        } else if (Value < object.value & object.left_child != null) {
            return search(object.left_child, Value);
        } else if (Value == object.value) {
            return true;
        }
        return false;
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

    private void insert(BinaryTree object, int Added_Value) {
        if (object.value > Added_Value) {
            if (object.left_child == null) {
                object.left_child = new BinaryTree(Added_Value);
            } else {
                this.insert(object.left_child, Added_Value);
            }
        } else {
            if (object.right_child == null) {
                object.right_child = new BinaryTree(Added_Value);
            } else {
                this.insert(object.right_child, Added_Value);
            }
        }
    }

    public void inOrder(){
        inOrder(this);
    }
    private void inOrder(BinaryTree object){
        if(object.left_child != null){
            inOrder(object.left_child);
        }
        System.out.printf(object.value + " ");
        if(object.right_child != null){
            inOrder(object.right_child);
        }
    }
    public void postOrder(){
        postOrder(this);
    }
    private void postOrder(BinaryTree object){
        if(object.left_child != null){
            postOrder(object.left_child);
        }
        if(object.right_child != null){
            postOrder(object.right_child);
        }
        System.out.printf(object.value + " ");
    }

    public void preOrder(){
        preOrder(this);
    }
    private void preOrder(BinaryTree object){
        System.out.printf(object.value + " ");
        if(object.left_child != null){
            postOrder(object.left_child);
        }
        if(object.right_child != null){
            postOrder(object.right_child);
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
