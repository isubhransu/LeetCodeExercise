import java.util.List;

/**
 * Created by subhransumishra on 3/18/16.
 */
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
public class InsertionsortLL {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

        printList(n1);

    }

/**

 */


    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode i = head;
        ListNode c = head.next;
        while(c.next != null){
                while(i != c) {
                    if (i.val > c.val) {
                        int temp;
                        temp = c.val;
                        c.val = i.val;
                        i.val = temp;
                    }
                    i = i.next;
                }
            c = c.next;
            i = head;
        }
        return head;
    }
}

