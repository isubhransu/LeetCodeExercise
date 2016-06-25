package LeetCode_Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by subhransumishra on 6/24/16.i
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * Example: {2, 3, 5, 5, 2}  Ans: 3
 *
 * Solution-1(Time O(n) & Space O(n)): Use a hashmap and traverse through the array put
 * all the lement as key and number of uccorances as value. Then iterate over
 * hashmap to see which one has 1 uccorance.
 *
 * Solution-2(Time O(n) & Space O(1)): Add value to a set. if you can't add to set then remove
 * the element. in the end you will one have one elment. return that.
 */

public class SingleNumber {
    public static void main(String[] args){
        int[] numarr = {3, 5, 1, 3, 5};
        Set<Integer> hs = new HashSet<>();

        for(int i: numarr){
            if(hs.add(numarr[i])){
                continue;
            }else{
                hs.remove(numarr[i]);
            }
        }
        System.out.println(hs.iterator().next());
    }
}
