package Heap;

import java.util.PriorityQueue;

/**
 * Created by subhransumishra on 6/8/16.
 */
public class KthBiggest {
    public static void main(String[] args){
        int[] data = {40,50,60,71,80,90,91,10,20,30,};
        System.out.println(getKth(data, 2));
    }

    public static int getKth(int[] data,int k){
        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for(int i=0; i<data.length; i++){
            q.offer(data[i]);

            if(q.size()>k){
                q.poll();
                System.out.println(q);
            }
        }
        return q.peek();
    }
}
