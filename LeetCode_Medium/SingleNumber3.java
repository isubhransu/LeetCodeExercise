package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by subhransumishra on 6/28/16.
 *
 * Problem: Given an array of numbers nums, in which exactly two elements appear only once and all the
 * other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 *
 * Solution: Bitwise Manupilation
 * Complexity:
 */
public class SingleNumber3 {
    //TODO
    public static void main(String[] args){
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(getTwoNum(arr)));
    }

    private static int[] getTwoNum(int[] arr){
        int AXORB = 0;
        int A= 0;
        int B=0;
        for(int i=0; i< arr.length; i++){
            AXORB ^= arr[i];
        }

        AXORB = (AXORB & (AXORB - 1)) ^ AXORB;

        for(int i = 0; i<arr.length; i++){
            if((AXORB & arr[i]) == 0)
                A ^= arr[i];
            else
                B ^= arr[i];
        }
        return new int[]{A, B};
   }
}
