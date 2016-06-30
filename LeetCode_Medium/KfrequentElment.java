package LeetCode_Medium;

import java.util.*;

/**
 * Created by subhransumishra on 6/29/16.
 *
 * Problem: Given a non-empty array of integers, return the k most frequent elements.
 * Example:
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * Solution:
 *
 * Complexity:
 */

class valkey{
    int val;
    int key;
    public valkey(int val,int key){
        this.val = val;
        this.key = key;
    }
}
public class KfrequentElment {
    //TODO: Java comparater study, how to create custom comparator for priorityqueue

    public static void main(String[] arg){
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(getFrequent(arr)));
    }

    private static int[] getFrequent(int[] arr){
        HashMap<Integer, valkey> freqHash = new HashMap<>();
        PriorityQueue<valkey> freqQueue =  new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            if(freqHash.containsKey(arr[i])){
                int temp =freqHash.get(arr[i]).val;
                freqHash.put(arr[i], new valkey(temp+1, arr[i]));
            }else{
                freqHash.put(arr[i], new valkey(1, arr[i]));
            }
        }

        //System.out.println(freqHash.size());

        for(Map.Entry<Integer, valkey> freq : freqHash.entrySet()){
            freqQueue.offer(freq.getValue());
            if(freqQueue.size()>2){
                freqQueue.poll();
            }
        }

        //System.out.println(freqQueue);

        int a = freqQueue.poll().key;
        int b = freqQueue.poll().key;

        return new int[]{a, b};
    }
}
