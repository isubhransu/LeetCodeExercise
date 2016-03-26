import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhransumishra on 2/8/16.
 */


public class Spiral2{
    public static void main(String args[]){

        System.out.println(genSpriral(3));
    }

    public static List<List<Integer>> genSpriral(int n) {
        List<List<Integer>> spiral = new ArrayList<List<Integer>>();




        for(int i = 0; i<n; i++){

            List<Integer> list = new ArrayList<Integer>();

            spiral.add(list);

            for(int j = 0; j <n; j++){

               list.add(1);

            }
        }





      return spiral;

    }
}