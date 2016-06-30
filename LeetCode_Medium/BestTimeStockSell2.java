package LeetCode_Medium;

/**
 * Created by subhransumishra on 6/29/16.
 * Problem:Say you have an array for which the ith element is the price of a given stock on day
 * i.Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in
 * multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 *
 * Example: [22, 4, 6, 12, 4, 9, 4, 15, 2] buy -> sell -> buy -> sell 2 + 6 + 5 + 9 = 24 (Max Profit)
 *
 * Solution: Iterate over the array keep first pointer on 2nd index(tomorrow), if we are
 * making profit tomorrow then add it to result. Greedy apraoch.
 *
 * Complexity: TC -> O(n), SC -> O(n).
 */


public class BestTimeStockSell2 {
    public static void main(String[] args){
        int[] arr = {22, 4, 6, 12, 4, 9, 4, 15, 2};
        System.out.println(getProfit(arr));
    }

    private static int getProfit(int[] arr){
        int res =0;
        //Check if we can make profit tomorrow, if so then add it to res
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                res += arr[i] - arr[i-1];
            }
        }

        return res;
    }
}
