/**
 * Created by subhransumishra on 3/23/16.
 */
public class Llreverese {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        reverseLL(n1, 2);
    }


    public static void reverseLL(ListNode n, int num){
        ListNode t = n;
        ListNode lh = n;
        ListNode p = n.next;
        ListNode b = n;
        int k = num;

        while(num-1 != 0){
            t = p.next;
            p.next = lh;
            lh = p;
            p = t;
            if(k == num){
                lh.next.next = null;
            }
            num--;
        }
        b.next = p;
        printList(lh);

    }

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
}
