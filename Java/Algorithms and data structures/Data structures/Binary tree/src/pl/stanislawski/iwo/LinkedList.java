package pl.stanislawski.iwo;

import java.util.Objects;

public class LinkedList {
    private int value;
    private LinkedList next;


    public LinkedList(int Value){
        this.value = Value;
        this.next = null;
    }

    public void addValue(int Value){
        addValue(this, Value);
    }

    private void addValue(LinkedList object, int Value){
        while(object.next != null){
            object = object.next;

        }
        object.next = new LinkedList(Value);
    }

    @Override
    public String toString() {
        return print(this);
    }



    private String print(LinkedList object){
        StringBuilder temp = new StringBuilder();
        while(object.next != null){
            temp.append(object.value).append(" ");
            object = object.next;
        }
        return temp.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList that)) return false;
        return getValue() == that.getValue() && Objects.equals(getNext(), that.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getNext());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }
}