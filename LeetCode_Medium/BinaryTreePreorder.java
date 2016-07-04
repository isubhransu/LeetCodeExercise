package LeetCode_Medium;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by subhransumishra on 7/3/16.
 *
 * Problem: Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Solution:
 * Complexity:
 */


//Definition for a binary tree node.

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BinaryTreePreorder {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(2);
        node2.left = new TreeNode(6);
        node2.right = new TreeNode(9);

        root.left = node1;
        root.right = node2;

        printPreoder(root);
    }

    public static void printPreoder(TreeNode node){
        Stack<TreeNode> nodestack = new Stack<>();

        nodestack.push(node);
        while(!nodestack.empty()){
            System.out.println("\b"+nodestack.peek().val);
            TreeNode tempnode = nodestack.pop();

            if(tempnode.right != null){
                nodestack.push(tempnode.right);
            }
            if(tempnode.left !=null){
                nodestack.push(tempnode.left);
            }


        }
    }
}
