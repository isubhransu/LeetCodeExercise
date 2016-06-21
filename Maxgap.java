import java.util.ArrayList;
/**
 * Created by subhransumishra on 6/20/16.
 * - Given an unsorted array, find the
 * maximum difference between the successive
 * elements in its sorted form.
 * - Try to solve it in linear time/space. O(n)
 * {3, 4, 13, 11, 1, 14, 22}, sorted -> {1, 3, 4, 6, 12, 17}
 * ans: 12 - 6 = 6;
 * Solution: radix_sort;
 *
 * The best way to solve this problem is use radix sort to
 * sort the array then iterate over to find the max gap
 * */

public class Maxgap {
    public static void main(String args[]) {
        int[] arr = {3, 4, 13, 11, 1, 14, 22};
        getMaxGap(arr);
    }
    //Complexity: Time -> O(n) & Space -> O(n);
    private static int getMaxGap(int[] arr) {
        return 0;
    }

    //Get radix sorted method
    //Complexity: Time -> O(n) & Space -> O(n)
    private static int[] getRadixSorted(int[] arr){
        ArrayList[] arrlist = new ArrayList[arr.length]; //SC -> O(n)


        Integer maxval = getMaxval(arr); //TC -> O(n)
        int digits = maxval.toString().length();

        //Here is the tricky part. How would you make 2 iterations by extracting
        // digits and putting them into the bucket

        for(int i=0; i<digits; i++){
            int modval = 10 ^ (digits-i-1);

            //Time complexity O(n)
            for(int j=0; j<arr.length; j++){
                if(arrlist[arr[i]%modval] == null){
                    arrlist[arr[i]%modval] = new ArrayList<Integer>();
                }
                arrlist[arr[i]%modval].add(arr[i]);
            }

            /**
             * arrlist[0] -> {10, 30, 80};
             * arrlist[1] -> null;
             * arrlist[2] -> {2, 42, 62};
             * arrlist[3] -> {3, 13};
             */

             // Called twice
             arr = updateArr(arrlist, arr); // TC -> O(n)

             // Update the arraylist in each iteration
             arrlist = new ArrayList[arr.length];
        }

    }

    // - Updates the array by iterating over the arrlist
    // - and each time it iterates we get closer to the sorted array
    // - Complexity: Time -> O(n) & Space -> O(1).
    // - Not creating any extra space.
    private static int[] updateArr(ArrayList[] arrlist, int[] arr){
        int counter=0;
        for(int k=0; k<arrlist.length; k++){
            if(arrlist[k] == null){
                continue;
            }else{
                int sum=0;
                List<Integer> templst = arrlist[k];
                for(int l=0; l<templst.size(); l++){
                    arr[counter+l] = (templst.get(templst.size()-l-1));
                    sum = l;
                }
                counter = counter+sum+1;
            }
        }
        return arr;
    }

    //Get max method
    //Complexity: Time -> O(n) & Space -> O(1)
    private static Integer getMaxval(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

}
