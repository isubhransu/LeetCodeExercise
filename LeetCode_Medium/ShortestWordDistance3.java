package LeetCode_Medium;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by subhransumishra on 6/28/16.
 * Problem: Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list. word1
 * and word2 may be the same and they represent two individual words in the list.
 *
 * Example: ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Solution: To make things easier take an integer array. [2, 4, 5, 4, 3, 8, 4]; getDinstance(3, 4) -> 2;
 * You need 2 pointers to find distance, a minDistance variable to keep track of minimum distance. Update
 * p1 or p2 respectively. Then check if p1 and p2 are not -1(they both have been previously reinitialized)
 * and they dont point to same index THEN update the minimum, and if word1 and word2 are same update p2 as
 * p1.
 *
 * Complexity: TC -> O(n), SC -> O(1);
 */


public class ShortestWordDistance3 {

    public static void main(String args[]){
        String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(getDistance(arr, "makes", "makes"));
    }

    private static int getDistance(String[] words, String word1, String word2){
        int minDistamce = Integer.MAX_VALUE;
        int p1=-1; int p2 = -1;

        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(word.equals(word1)){
                p1 = i;
            }else if(word.equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1 && p1 != p2){
                minDistamce = Math.min(minDistamce, Math.abs(p1-p2));
            }

            if(word1.equals(word2)){
                p2 = p1;
            }
        }
        return minDistamce;
    }
}
