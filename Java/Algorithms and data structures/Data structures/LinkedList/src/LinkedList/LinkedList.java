package LinkedList;

public class LinkedList {
    int value;
    LinkedList next;
    public LinkedList(int value){
        this.value = value;
        this.next = null;
    }

    public void add(int value){
        LinkedList temp = this;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new LinkedList(value);
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

    public boolean conteinValue(int value){
        LinkedList linkedList = this;
        while(linkedList != null){
            if(linkedList.value == value){
                return true;
            }
            linkedList = linkedList.next;
        }
        return false;
    }
}
