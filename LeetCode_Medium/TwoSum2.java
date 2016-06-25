package LeetCode_Medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by subhransumishra on 6/24/16.
 *
 * Problem: Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 *
 * Example: Input: numbers={2, 7, 11, 15}, target=9, Output: index1=1, index2=2
 *
 * Solution: This comes under "Two pointer problems". Start from assigning
 * one pointer to start of array and 2nd to the end of array. If value in both array indices is equals to given number
 * then return the indices. Or if sum is less than the number then reduce(-1) 2nd pointer. If greater then increase
 * the 1st pointer(+1) in one iteration. Like wise iteratre over the array.
 *
 * Complexity: TC -> O(n), SC -> O(n)
 */
public class TwoSum2 {
    public static void main(String[] args){
        int[] arr ={2, 7, 11, 15};
        System.out.println(helper(arr, 9));
    }

    private static List<Integer> helper(int[] arr, int num){
        List<Integer> indexls = new LinkedList<>();
        int p1 = 0; int p2 = arr.length-1;
        for(int i =0; i< arr.length; i++){
            if(arr[p1]+arr[p2] == num){
                indexls.add(p1);
                indexls.add(p2);
                break;
            }
            if(arr[p1]+arr[p2] > num){
                p2--;
            }else{
                p1++;
            }
        }
        return indexls;
    }
}
