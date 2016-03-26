/**
 * Created by subhransumishra on 3/23/16.
 */

import java.util.List;

/**
 * Created by subhransumishra on 3/18/16.
 */
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}

public class Addnumbers {

    public static void main(String[] args) {
        ListNode2 n1 = new ListNode2(2);
        ListNode2 n2 = new ListNode2(4);
        ListNode2 n3 = new ListNode2(3);

        ListNode2 n4 = new ListNode2(5);
        ListNode2 n5 = new ListNode2(6);
        ListNode2 n6 = new ListNode2(4);
        ListNode2 n7 = new ListNode2(5);

        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        addLL(n1, n4);

    }

    public static void addLL(ListNode2 n1, ListNode2 n2){
        int c = 0;
        int sum = n1.val+n2.val;
        ListNode2 p;
        boolean cbool = false;
        if(sum < 10) {
             p = new ListNode2(sum);
        }else{
             p = new ListNode2(sum-10);
             cbool = true;
        }
        ListNode2 r = p;
        //p.next = null;
        n1 = n1.next;
        n2 = n2.next;


        while(n1 != null || n2 != null){
            System.out.println("here");
            if(n1 == null){
                sum = n2.val;
                n2 = n2.next;
            }else{
                sum = n1.val;
                n1 = n1.next;
            }

            System.out.println(sum);
            ListNode2 n;
            if(sum < 10){
                if(cbool == true) {
                    n= new ListNode2(sum + 1);
                }else{
                    n= new ListNode2(sum);
                }
                p.next = n;
                p = p.next;
                cbool = false;
            }else{
                c = sum - 10;
                n= new ListNode2(c);
                p.next = n;
                p = p.next;
                cbool = true;
            }

            if(n1 != null && n2 != null) {
                n1 = n1.next;
                n2 = n2.next;
            }


            System.out.println(n1);
            System.out.println(n2);
        }

        printList(r);
    }

    public static void printList(ListNode2 x) {
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


