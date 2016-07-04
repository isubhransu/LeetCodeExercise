package LeetCode_Medium;

import java.util.Stack;

/**
 * Created by subhransumishra on 7/3/16.
 * Problem: Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Solution: You can use a single stack to implement it.
 * Complexity: TC -> O(n), SC -> O(n)
 */

public class BinaryTreeInorder {
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

        printInorder(root);
    }

    private static void printInorder(TreeNode node){
        Stack<TreeNode> nodestack = new Stack<>();

        nodestack.push(node);
        while(!nodestack.isEmpty()){

            if(nodestack.peek().left != null){
                //System.out.println(node.val);
                node = node.left;
                nodestack.push(node);
            }

            while(!nodestack.isEmpty() && nodestack.peek().right==null && nodestack.peek().left==null){
               // System.out.println("Inner while"+nodestack.pop().val);
                if(!nodestack.isEmpty()){
                    TreeNode tempnode = nodestack.pop();
                 //   System.out.println(tempnode.val);
                    if(tempnode.right != null){
                        nodestack.push(tempnode.right);
                    }
                }

            }
        }
    }
}
