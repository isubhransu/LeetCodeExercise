package LeetCode_Medium;

import java.util.ArrayList;

/**
 * Created by subhransumishra on 6/28/16.
 *
 * Problem:Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned
 * by next should be: [1, 3, 2, 4, 5, 6].
 *
 * Solution: This is fairly simple program. Use a cvariable as a flipflop to switch between
 * to lists. and iterate over two arrays.
 *
 * Complexity: TC -> O(m+n) SC -> O(1);
 */

public class ZigZagIterator{
    public static void main(String args[]){
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4, 5, 6, 7};
        ZigZagIteratorHelper zz = new ZigZagIteratorHelper(arr1, arr2);

        while(zz.hasNext()){
            System.out.println(zz.next());
        }
    }
}
class ZigZagIteratorHelper {
    private int[] arr1;
    private int[] arr2;
    private int i;
    private int j;
    private int listid;
    private int val;

    public ZigZagIteratorHelper(int[] arr1, int[] arr2){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.i = 0;
        this.j = 0;
        this.listid = 0;
        this.val = 0;
    }

    public int next(){
        if(listid == 0 && hasNext()){
           if(arr1.length > i) {
               val = arr1[i];
               i++;
               this.listid = 1;
               if (arr2.length  == j) {
                   this.listid = 0;
               }
               return val;
           }
        }
        if(listid == 1 && hasNext()){
            if(arr2.length > j) {
                val = arr2[j];
                j++;
                this.listid = 0;
                if (arr1.length  == i) {
                    this.listid = 1;
                }
                return val;
            }
        }
        return 0;
    }

    public boolean hasNext(){
        return (arr1.length > i || arr2.length > j);
    }

}
