import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by subhransumishra on 2/23/16.
 */
public class Filepathlength {

    public static void main(String[] str) {
        System.out.println(solution("dir1\n dir12\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif"));
    }

    public static int solution(String S) {
        List<String> list = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        String[] words = S.split("\n");
        int k =0;
        for (String word : words) {
            if (word.contains(".jpeg") || (word.contains(".gif"))) {
                list.add(word);
                pos.add(k);
            }
            k++;
        }
        //int spacecount = 0;

        List<Integer> spacecount = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int count = 0;
            String word = (String) iterator.next();

            for (char c : word.toCharArray()) {
                if (c == ' ') {
                    count++;
                }

            }
            spacecount.add(count);
        }

        int len = 0;
        for(int i=0; i<list.size(); i++){

            int n = spacecount.get(i);
            int p = pos.get(i)-1;
            while(n!=0){
                len = len + words[p].length();
                n--;
                p--;
            }
        }
        return len;
    }
}
