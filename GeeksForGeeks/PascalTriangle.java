package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by subhransumishra on 7/10/16.
 * Problem:
 * Example:
 * Solution:
 * Complexity:
 */
public class PascalTriangle{

    //TODO it works in O(n^2) TC and O(n) SC but code is not clean. clean the code.

    public static void main(String[] args){
        printPascalTriangle(10);
    }

    public static void printPascalTriangle(int n){
        ArrayList<Integer> pascallist = new ArrayList<>();

        pascallist.add(1);
        pascallist.add(1);

        if(n == 1){
            System.out.println(1);
            return;
        }

        if(n == 2){
            System.out.println(1);
            System.out.println("1 1");
            return;
        }

        System.out.println(1);
        System.out.println("1 1");

        printaPascalHelper(n-2, pascallist);
    }

    public static void printaPascalHelper(int n, ArrayList<Integer> pascallist){

        ArrayList<Integer> prevlist = new ArrayList<>();

        int val =4;
        while(n > 0){
            prevlist =new ArrayList<Integer>(pascallist);

            val = prevlist.size();
            System.out.print(1+" ");
            pascallist = new ArrayList<>();
            pascallist.add(1);

            for(int i=0; i<val-1; i++){
                int sum = prevlist.get(i)+prevlist.get(i+1);
                pascallist.add(i+1, sum);
                System.out.print(sum+" ");

            }

            System.out.print(1);
            pascallist.add(1);
            System.out.println("");

            n --;
        }

    }
}
