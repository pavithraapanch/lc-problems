package mediumLC;

public class flattenDoublyLL {

    public static void main(String args[]){
        ListNode head = null;
        head = ListNode.insertNode(head, 1);
        head = ListNode.insertNode(head, 2);
        head = ListNode.insertNode(head, 3);
        head = ListNode.insertNode(head, 4 );

        ListNode.printList(head);
        ListNode cHead = flattenDoublyLL(head);
        System.out.println("");
        ListNode.printList(cHead);
    }

    public static ListNode flattenDoublyLL(ListNode head){
        if (head == null) return null;
        ListNode prev = head;
        ListNode curr = head;

        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
                continue;
            }
            //find the tail of child and link to the next node
            ListNode temp = curr.child;
            while(temp.next != null)
                temp = temp.next;
            temp.next = curr.next;
            if(curr.next != null) curr.next.prev = temp;

            //remove ties with the child
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return prev;
    }
}
