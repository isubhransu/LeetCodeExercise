package LeetCode_Medium;

import AbstractClass_Challenge.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by subhransumishra on 7/6/16.
 * Problem: The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house has one and
 * only one parent house. After a tour, the smart thief realized that "all houses in this
 * place forms a binary tree". It will automatically contact the police if two directly-linked
 * houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.

 * Example:
 * Solution:
 * Complexity:
 */

class BinaryTreeNode{
    BinaryTreeNode left;
    BinaryTreeNode right;
    int val;

    BinaryTreeNode(int val){
        this.val = val;
    }
}



public class HouseRobber3 {
    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        node1.left = new BinaryTreeNode(1);
        node1.right = new BinaryTreeNode(2);
        node2.left = new BinaryTreeNode(6);
        node2.right = new BinaryTreeNode(9);

        root.left = node1;
        root.right = node2;

        /**
         *     5
         *   |   \
         *   3    8
         *   | \  | \
         *   1  2 6  9
         */


        System.out.println(getMaxAmount(root));
    }

    private static int getMaxAmount(BinaryTreeNode node){
        Queue<BinaryTreeNode> NodeQueue1 = new LinkedList<>();
        Queue<BinaryTreeNode> NodeQueue2 = new LinkedList<>();
        int sum1= 0;
        int sum2= 0;

        NodeQueue1.offer(node);

        while(!NodeQueue1.isEmpty() || !NodeQueue2.isEmpty()){
            while(!NodeQueue1.isEmpty()){
                BinaryTreeNode tempnode = NodeQueue1.poll();
                sum1 += tempnode.val;

                if(tempnode.left != null){
                    NodeQueue2.offer(tempnode.left );
                }

                if(tempnode.right != null){
                    NodeQueue2.offer(tempnode.right);
                }
            }

            while(!NodeQueue2.isEmpty()){
                BinaryTreeNode tempnode = NodeQueue2.poll();
                sum2 += tempnode.val;

                if(tempnode.left != null){
                    NodeQueue1.offer(tempnode.left );
                }

                if(tempnode.right != null){
                    NodeQueue1.offer(tempnode.right);
                }
            }
        }
        return Math.max(sum1, sum2);
    }
}
