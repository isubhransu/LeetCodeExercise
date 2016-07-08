package LeetCode_Medium;

/**
 * Created by subhransumishra on 7/7/16.
 * Problem:
 * Example:
 * Solution:
 * Complexity:
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        node1.left = new BinaryTreeNode(1);
        node1.right = new BinaryTreeNode(2);
        node2.left = new BinaryTreeNode(6);
        node2.right = new BinaryTreeNode(9);
        node2.right.left = node3;

        root.left = node1;
        root.right = node2;

        /**
         *     5
         *   |   \
         *   3    8
         *   | \  | \
         *   1  2 6  9
         *          /
         *         4
         */


        System.out.println(getBinaryTreeDepth(root, 0));
    }

    private static int getBinaryTreeDepth(BinaryTreeNode node, int count){

        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return count;
        }
        count++;

        return Math.max(getBinaryTreeDepth(node.left, count), getBinaryTreeDepth(node.right, count));
    }
}
