public class ListNode {
    public int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;this.next = null; }
    public void add(ListNode noden) {
        this.next = noden; }
}
