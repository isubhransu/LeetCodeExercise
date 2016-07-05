package LeetCode_Medium;

/**
 * Created by subhransumishra on 7/4/16.
 * Problem: Given a singly linked list, group all odd nodes together followed
 * by the even nodes. Please note here we are talking about the node number
 * and not the value in the nodes. You should try to do it in place. The
 * program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Solution:
 * Complexity:
 */


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class OddEvenLinkedLst {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        makeOddEvenList(node1);
    }

    private static void makeOddEvenList(ListNode node){
        ListNode p1 = node;
        ListNode p2 = node.next;
        ListNode temp = node.next;

        while(p2!=null){

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = temp;

        while(node != null){
           System.out.println(node.val);
            node = node.next;
        }
    }
}
