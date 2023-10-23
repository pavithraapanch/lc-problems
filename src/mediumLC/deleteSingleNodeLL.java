package mediumLC;

public class deleteSingleNodeLL {

    public static void main(String args[]){
        ListNode head = null;
        head = ListNode.insertNode(head, 1);
        head = ListNode.insertNode(head, 2);
        head = ListNode.insertNode(head, 3);
        head = ListNode.insertNode(head, 4 );

        ListNode.printList(head);
        //ListNode node = getNode(head, 3);
        //deleteNode(node);
        head = reverseLinkedList(head);
        ListNode.printList(head);
    }

    /**
     * Function to delete Node in the linked list
     */
    public static void deleteNode(ListNode node){
        if(node == null){ return; }
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }

    /**
     * Gets the right node reference to delete.
     */
    public static ListNode getNode(ListNode head, int val){
        if (head == null) return null;
        ListNode curr = head;
        while(curr.val != val) { curr = curr.next; }
        return curr;
    }

    /**
     * Check intersection in a linked List
     */
    public static ListNode intersectionPresent(ListNode head1, ListNode head2){
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        while(ptr1 != ptr2){
            ptr1 = (ptr1 == null) ? head2 : ptr1.next;
            ptr2 = (ptr2 == null) ? head1 : ptr2.next;
        }
        return ptr1;
    }

    /**
     * Reverse a singly LL
     */
    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        //1->2->3
        //null<-1<-2<-3

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }


}

