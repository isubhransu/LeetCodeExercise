/**
 * Created by subhransumishra on 2/7/16.
 */
import java.util.*;

public class MatrixCycle{
    public static void main(String args[]){
        ArrayList<Integer> places = new ArrayList<Integer>(
                Arrays.asList(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35));
        System.out.println(rotateArray(places, 56));
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int p = 0;
        if(B > A.size()){
            B = B % A.size();
        }
        System.out.println(B);
        System.out.println(A.size());

        for(int i = 0; i<A.size(); i++){
            if(i+B<A.size()){
                ret.add(A.get(i+B));
            }else{
                ret.add(A.get(i-(A.size()-B)));
            }
        }
        return ret;
    }
}