package GeeksForGeeks;

/**
 * Created by subhransumishra on 7/10/16.
 * Problem:
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
public class CompareTwoBinaryTree {
    public static void main(String[] args){
        BinaryTreeNode root1 = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        node1.left = new BinaryTreeNode(1);
        node1.right = new BinaryTreeNode(2);
        node2.left = new BinaryTreeNode(6);
        node2.right = new BinaryTreeNode(9);
        node2.right.left = node3;

        root1.left = node1;
        root1.right = node2;

        BinaryTreeNode root2 = new BinaryTreeNode(5);
        BinaryTreeNode node11 = new BinaryTreeNode(3);
        BinaryTreeNode node22 = new BinaryTreeNode(8);
        BinaryTreeNode node33 = new BinaryTreeNode(4);
        node11.left = new BinaryTreeNode(1);
        node11.right = new BinaryTreeNode(2);
        node22.left = new BinaryTreeNode(6);
        node22.right = new BinaryTreeNode(9);
        node22.right.left = node33;

        root2.left = node11;
        root2.right = node22;

        System.out.println(check2BinaryTrees(root1, root2));
    }

    public static boolean check2BinaryTrees(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1.val != root2.val){
            return false;
        }

        return check2BinaryTrees(root1.left, root2.left) && check2BinaryTrees(root1.right, root2.right);
    }
}
