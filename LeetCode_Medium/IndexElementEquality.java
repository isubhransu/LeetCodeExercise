package LeetCode_Medium;

/**
 * Created by subhransumishra on 6/24/16.
 * Problem: Given an array of sorted distinct integers named arr, write a function that returns
 * an index i in arr for which arr[i] = i or -1 if no such index exists.
 * Implement the most efficient solution possible, prove the correctness of your
 * solution and analyze its runtime complexity (in terms of n - the length of arr).
 *
 * Examples:
 * Given arr = [-8,0,2,5] the function returns 2, since arr[2] = 2
 * Given arr = [-1,0,3,6] the function returns -1, since no index in arr satisfies arr[i] = i
 *
 * Solution: The naive solution is to iterate on all items in the array and check the condition. This takes
 * linear O(n) runtime complexity.

 To do better, we should recognize that both the sequence of i (array indices) and the sequence of arr[i] (array
 values) are strictly monotonically increasing sequences. If we subtract i from both sides of the equation
 arr[i] = i we get arr[i] - i = 0. Since the difference arr[i] - i = 0 consists of strictly monotonically
 increasing sequences it is a strictly monotonically increasing sequence by itself. We can use this to define
 another array diffArr where diffArr[i] = arr[i] - i and perform a binary search for 0 on diffArr.
 We don't need to really create this array, and can just modify the binary search condition to arr[i] - i = 0
 (instead of the condition diffArr[i] = 0).

 So why is it important that for the search condition to form a strictly monotonically increasing sequence?
 On each step of this modified binary search where the current index is j, to cut our array limit in half and
 drop the other half we must be confident that:

 arr[j] - j ≥ arr[q] - q  for every index  j > q
 arr[j] - j ≤ arr[p] - p  for every index  j < p
 This can be easily established by showing that arr[i] - i is a strictly monotonically increasing sequence.

 After proving its correctness, we can implement the search:
 * Complexity:
 */

public class IndexElementEquality {
    public static void main(String[] args){
        int[] arr = {-8,0,2,5};
        System.out.println(helper(arr));
    }

    private static int helper(int[] arr){
        int mid ;
        int start = 0; int end = arr.length;

        while(start != end){
            mid = (end - start + 1)/2;
            if(arr[mid] > mid) {
                end = mid - 1;
            } else
            if(arr[mid] < mid){
            start = mid;
        }else{
                return mid;
            }
        }
        return -1;
    }
}
