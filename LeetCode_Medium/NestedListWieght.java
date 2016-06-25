package LeetCode_Medium;

/**
 * Created by subhransumishra on 6/24/16.
 * Problem: Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 *
 * Solution: iterate recursively over the nested list. One recursive call implies one depth(+1) deeper. keep adding
 * the sum and return in each resursive call to uper stack.
 * Complexity:  TC: O(n), SC: O(1), n is the size of the nestedlist
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


public class NestedListWieght {
    public static void main(String[] args){
        List<NestedInteger> nestedList;
        helper(nestedList, 1)
    }

    // [[1,1],2,[1,1]]
    // TC: O(n), SC: O(1), n is the size of the nestedlist

    public static int helper(List<NestedInteger> nestedlist, int depth){
        int sum =0;
        if(nestedlist == null){
            return 0;
        }

        for(int i: nestedlist){
            if(i.getInteger()){
                sum = sum + i.getInteger()*depth;           // 1st: 0+2*1 + 0+2*1, 2nd: 4 + 2*1 = 6, 3rd: 2 + 2
            }else{
                sum = sum + helper(i.getlist(), depth+1);  // 1st: 0 + 4, 2nd: 6 + 4 = 10
            }
        }

        return sum;  // 1st:returns 4, 2nd: return 4, 3rd: return 10
    }
}