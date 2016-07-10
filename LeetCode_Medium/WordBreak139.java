package LeetCode_Medium;

import java.util.HashSet;

/**
 * Created by subhransumishra on 7/8/16.
 * Problem:Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * Solution:
 * Complexity:
 */
public class WordBreak139{
    //TODO Check the dynamic programming solution

    public static void main(String[] args){
        String s = "abcd";
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("abc");
        dict.add("b");
        dict.add("cd");

        System.out.print(wordsBreak(s, dict));
    }

    private static boolean wordsBreak(String s, HashSet<String> dict){
        if(dict.contains(s)){
            return true;
        }

        for(int i=1; i<s.length(); i++){
            if(dict.contains(s.substring(0, i))){
                if(wordsBreak(s.substring(i, s.length()), dict)){
                    return true;
                }
            }
        }
        return false;
    }
}
