package LinkedList;

import java.util.Objects;

/*
Dostęp do pamięci: O(1).
Dostęp do Odczyt: O(n).
Iteracja O(n).
Usuwanie O(1).
 */

public class LinkedList {
    int value;
    LinkedList next;
    public LinkedList(int value){
        this.value = value;
        this.next = null;
    }

    public LinkedList() {}
    public LinkedList(LinkedList o1){
        this.next = o1;
    }
    public void addLast(int value){
        LinkedList temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new LinkedList(value);
    }

    public LinkedList addFirst(int value){
        LinkedList head = new LinkedList(value);
        head.next = this;
        return head;
    }


    public void print(){
        if(this == null){
            System.out.println("Pusta lista");
            return;
        }
        LinkedList temp = this;
        while (temp != null){
            if(temp.next != null)
                System.out.print(temp.value + "-> ");
            else
                System.out.print(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public LinkedList delete(int value){
        LinkedList head = this;
        LinkedList temp = this;
        LinkedList prev = this;
        if(temp.value == value){
            return temp.next;
        }
        while(temp != null){
            if(value == temp.value){
                prev.next = temp.next;
                temp.next = null;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public LinkedList reverse(){
        LinkedList next = null;
        LinkedList prev = null;

        LinkedList current = this;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev =current;
            current = next;
        }
        return prev;
    }

    public boolean containValue(int value){
        LinkedList linkedList = this;
        while(linkedList != null){
            if(linkedList.value == value){
                return true;
            }
            linkedList = linkedList.next;
        }
        return false;
    }

    public static LinkedList merge(LinkedList o1, LinkedList o2){
        if(o1 == null && o2 == null){
            return null;
        } else if (o1 == null && o2 != null) {
            return o2;
        } else if (o1 != null && o2 == null) {
            return o1;
        }
        LinkedList head = o1;
        LinkedList temp = o1;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new LinkedList(o2);
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList that)) return false;
        LinkedList o2 = (LinkedList) this;
        LinkedList o1 = (LinkedList) o;
        while (o != null && o2 != null){
            if (o1.value != o2.value) return false;
            o1 = o1.next;
            o2 = o2.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
