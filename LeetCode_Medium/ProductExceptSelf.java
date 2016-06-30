package LeetCode_Medium;
import java.util.Arrays;

/**
 * Created by subhransumishra on 6/29/16.
 *
 * Problem: Given an array of n integers where n > 1, nums, return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 * Example, given [1,2,3,4], return [24,12,8,6].
 * Solution:
 *               t1 -> [1, 1, 2, 6]
 *               t2 -> [24, 12, 4, 1]
 *               result -> t1 * t2 = [24, 12, 8, 6]
 *
 * Complexity: TC -> O(n), SC -> O(n)
 */
public class ProductExceptSelf {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        System.out.print(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len];
        int[] before = new int[len];
        int[] after = new int[len];

        before[0] = 1;
        for (int i = 1; i < len; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }
        System.out.print(Arrays.toString(before));

        after[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }
        System.out.print(Arrays.toString(after));

        for (int i = 0; i < len; i++) {
            result[i] = before[i] * after[i];
        }

        return result;
    }
}
