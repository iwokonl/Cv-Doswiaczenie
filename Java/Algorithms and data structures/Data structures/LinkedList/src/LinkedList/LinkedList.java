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
        LinkedList temp = this;
        while (temp != null){
            if(temp.next != null)
                System.out.print(temp.value + "-> ");
            else
                System.out.print(temp.value);
            temp = temp.next;
        }
    }
}
