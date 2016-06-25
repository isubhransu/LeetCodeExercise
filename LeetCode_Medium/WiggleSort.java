package LeetCode_Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by subhransumishra on 6/24/16.
 * Problem: Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Do it linear time and in -place.
 * Example: nums = [3, 5, 1, 6, 2, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * Solution: Iterate over and swap elements if they do not satisfy condition.
 * Complexity: TC -> O(n), SC -> O(1)
 */
public class WiggleSort {
    public static void main(String[] args){
        int[] numarr = {3, 0, 1, 6, 2, 4, 7, 8, 4, 5, 20};

        for(int i = 0; i<numarr.length; i++){
            if(i+1 == numarr.length-1){break;}

            if(numarr[i] <= numarr[i+1]){
                continue;
            }else{
                numarr = swapval(i, i+1, numarr);
            }
            if(numarr[i+1] >= numarr[i+2]){
                continue;
            }else {
                numarr = swapval(i + 1, i + 2, numarr);
            }

        }

        System.out.println(Arrays.toString(numarr));
    }

    private static int[] swapval(int n1, int n2, int[] arr){
        System.out.println("first "+n1+": Second "+n2);
        int temp = arr[n2];
        arr[n2] =  arr[n1];
        arr[n1] = temp;

        return arr;
    }
}
