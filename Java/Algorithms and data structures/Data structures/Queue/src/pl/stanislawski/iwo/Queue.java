package pl.stanislawski.iwo;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> storage;

    public Queue(){
        storage = new LinkedList<>();
    }

    public Integer dequeue(){
        return storage.removeFirst();
    }
    public void enqueue(int value){
        storage.addLast(value);
    }
    @Override
    public String toString() {
        return storage.toString();
    }

    public int size(){
        return storage.size();
    }

    public int peek(){
        return storage.getFirst();
    }
}
