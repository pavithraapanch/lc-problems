package mediumLC;

public class ListNode {
    int val;
    ListNode next;
    ListNode random;
    ListNode child;
    ListNode prev;

    public ListNode(int num) {
        val = num;
        next = null;
        random = null;
        child = null;
    }
    public ListNode(int num, ListNode node){
        val = num;
        next = node;
    }

    /**
     * Function to insert Node in the end of singly linked list
     */
    public static ListNode insertNode(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        ListNode curr = head;
        while(curr.next != null){ curr = curr.next; }
        curr.next = newNode;
        return head;
    }

    /**
     * Printing linked list
     */
    public static void printList(ListNode head){
        if(head == null) return;
        while(head.next != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print(head.val);
        return;
    }
}
