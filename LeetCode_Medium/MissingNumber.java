package LeetCode_Medium;

/**
 * Created by subhransumishra on 7/3/16.
 *
 * Problem: Given an array containing n distinct numbers taken from
 * 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example:
 * Given nums = [0, 1, 3] return 2.
 *
 * Solution: XOR all the numbers then xor it with numbers in array.
 * Complexity:TC -> O(n), SC -> O(1)
 */
public class MissingNumber {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 5};
        int x = 0;

        for(int i=0; i<arr.length+1; i++){
            x^=i;
        }

        for(int i=0; i<arr.length; i++){
            x^=arr[i];
        }

        System.out.println(x);
    }
}
