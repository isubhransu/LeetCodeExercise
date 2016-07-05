package LeetCode_Medium;

/**
 * Created by subhransumishra on 7/4/16.
 * Problem: Given an array of n integers nums and a target, find the number
 * of index triplets i, j, k with 0 <= i < j < k < n that satisfy the
 * condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example:
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Solution:
 * Complexity:
 */
public class SumSmaller3{
    public static void main(String[] args){
        int[] arr = {-2, 0, 1, 3};
        System.out.println(getSumSmaller3Count(arr, 2));
    }

    private static int getSumSmaller3Count(int[] numarr, int k){
        int count=0;

        for(int i=1; i<numarr.length-1; i++){
            //call the method
            count += sumSmaller3helper(numarr, i, k);
            System.out.println("sumSmaller3helper -> "+sumSmaller3helper(numarr, i, k));
        }
        return  count;
    }

    private static int sumSmaller3helper(int[] arr, int p, int k){
        int p1=0;
        int p2=arr.length-1;
        int tempcount=0;
        int sum=0;
        //System.out.println("int sumsmaller3helper");


        while(p1 != p){
            if(p2 == p){
                break;
            }
            sum = arr[p1] + arr[p2] + arr[p];
            System.out.println("Sum -> "+sum);
            if(sum < k){
                p1++;
                tempcount++;
            }else{
                p2--;
            }
            System.out.println("p1 -> "+p1+", p2 -> "+p2+", p -> "+p);
        }
        return tempcount;
    }
}
