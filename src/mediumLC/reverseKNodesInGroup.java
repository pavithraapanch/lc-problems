package mediumLC;

public class reverseKNodesInGroup {

    public static void main(String args[]){
        ListNode head = null;
        head = ListNode.insertNode(head, 1);
        head = ListNode.insertNode(head, 2);
        head = ListNode.insertNode(head, 3);
        head = ListNode.insertNode(head, 4 );
        head = ListNode.insertNode(head, 5 );
        head = ListNode.insertNode(head, 6 );
        head = ListNode.insertNode(head, 7 );

        ListNode.printList(head);
        head = reverseKNodesInGroup(head, 2);
        System.out.println("");
        ListNode.printList(head);
    }

    public static ListNode reverseKNodesInGroup(ListNode head, int k){
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummyHead;

        while(curr != null){
            ListNode tail = curr;
            int listIndex = 0;

            while(curr != null && listIndex < k){
                curr = curr.next;
                listIndex++;
            }

            if(listIndex != k){
                prev.next = tail;
            }else {
                prev.next = reverse(tail, k);
                prev = tail;
            }
        }
        return dummyHead.next;
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null && k-- > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


/*
Given: 1->2-3-4-5-6-7 , k=2
Exp: 2-1-4-3-6-5-7

reverse() ListNode

* */