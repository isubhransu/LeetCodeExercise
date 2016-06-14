package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by subhransumishra on 6/12/16.
 */
public class KMostFreq {
    public static void main(String args[]){
        int[] arr = {1,2,3, 4, 5, 2, 2, 1, 1};
        getElement(arr, 2);
    }

    public static List<Integer> getElement(int[] arr, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List ls = new ArrayList();
        HashMap<Integer, Integer> hm = new HashMap();

        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }else{
                hm.put(arr[i], 1);
            }
        }

        for(Integer i : hm.keySet()){
            q.offer(hm.get(i));
            ls.add(i);
            if(q.size()>k){
                q.poll();
                ls.remove(i);
            }
        }
        return ls;
    }
}
