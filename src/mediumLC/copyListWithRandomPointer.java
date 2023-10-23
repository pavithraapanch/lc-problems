package mediumLC;

public class copyListWithRandomPointer {

    public static void main(String args[]){
        ListNode head = null;
        head = ListNode.insertNode(head, 1);
        head = ListNode.insertNode(head, 2);
        head = ListNode.insertNode(head, 3);
        head = ListNode.insertNode(head, 4 );

        ListNode.printList(head);
        ListNode cHead = copyListWithRandomPointer(head);
        System.out.println("");
        ListNode.printList(cHead);
    }

    public static ListNode copyListWithRandomPointer(ListNode head){
        if (head == null) return null;

        ListNode curr = head;
        ListNode copy, next;

        //make copy nodes in the list
        //1->1'->2->2'
        while(curr!= null){
            next = curr.next;
            copy = new ListNode(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        //assign random pointer to the correct node
        curr = head;
        while(curr!= null){
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //remove all the extras
        curr = head;
        ListNode copyHead = head.next;
        copy = copyHead;

        //1->1'->2->2'
        while(copy.next != null){
            curr.next = curr.next.next;
            curr = curr.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
