package LeetCode_Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by subhransumishra on 7/8/16.
 * Problem:Serialization is the process of converting a data structure or object into a sequence
 * of bits so that it can be stored in a file or memory buffer, or transmitted across a network
 * connection link to be reconstructed later in the same or another computer environment. Design
 * an algorithm to serialize and deserialize a binary tree. There is no restriction on how your s
 * erialization/deserialization algorithm should work. You just need to ensure that a binary tree
 * can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *
 *1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]"

 * Solution:
 * Complexity:
 */


class Node{
    Node left;
    Node right;
    int val;

    Node(int val){
        this.val = val;
    }
}
public class SerializeDeserializeBinaryTree297 {
    public static void main(String[] args){
        Node root = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(8);
        Node node3 = new Node(4);
        node1.left = new Node(1);
        node1.right = new Node(2);
        node2.left = new Node(6);
        node2.right = new Node(9);
        node2.right.left = node3;

        root.left = node1;
        root.right = node2;


        /**
         *     5
         *   |   \
         *   3    8
         *   | \  | \
         *   1  2 6  9
         */

        String serialized = serializeBinaryTree(root);
        //System.out.print(serialized);
        deserializeBinaryTree(serialized);
    }

    private static String serializeBinaryTree(Node node){
        Queue<Node> NodeQueue1 = new LinkedList<>();
        Queue<Node> NodeQueue2 = new LinkedList<>();
        String S="";

        NodeQueue1.offer(node);

        while(!NodeQueue1.isEmpty() || !NodeQueue2.isEmpty()){
            while(!NodeQueue1.isEmpty()){
                Node tempnode = NodeQueue1.poll();
                S += tempnode.val+",";

                if(tempnode.left != null){
                    NodeQueue2.offer(tempnode.left );
                }else{
                    S += "null,";
                }

                if(tempnode.right != null){
                    NodeQueue2.offer(tempnode.right);
                }else{
                    S += "null,";
                }
            }

            while(!NodeQueue2.isEmpty()){
                Node tempnode = NodeQueue2.poll();
                S += tempnode.val+",";

                if(tempnode.left != null){
                    NodeQueue1.offer(tempnode.left );
                }else{
                    S += "null,";
                }

                if(tempnode.right != null){
                    NodeQueue1.offer(tempnode.right);
                }else{
                    S += "null,";
                }
            }
        }
        return S;
    }

    private static void deserializeBinaryTree(String S){
        String[] nodearray = S.split(",");
        System.out.print(Arrays.toString(nodearray));
        int nodeval = Integer.valueOf(nodearray[0]);
        Node node = new Node(nodeval);

        for(int i=1; i<nodearray.length; i++){

        }
    }
}
