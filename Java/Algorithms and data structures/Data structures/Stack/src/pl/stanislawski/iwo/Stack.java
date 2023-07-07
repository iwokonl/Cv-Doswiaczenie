package pl.stanislawski.iwo;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> storage;

    public Stack(){
        storage = new LinkedList<>();
    }

    public void push(int value){
        storage.addLast(value);
    }

    public void pop(){
        storage.removeLast();
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    public int size(){
        return storage.size();
    }

}
