
import java.lang.Math.*;

/**
 * Created by subhransumishra on 2/8/16.
 */
public class Squarert {

        public static void main(String[] args){
            System.out.println(sqrt(851021640));
        }

        public static int sqrt(int a) {
            int j = 0;
            int p = 1;
            while (j==0){
                //System.out.println(p*p);
                int m = p+1;
                if((a - p*p)==0){
                    break;
                }else
                    if (Math.abs(a-p*p)<Math.abs(a-(m*m))){
                    break;
                }
                //System.out.println(p);
                p++;
            }
            return p;
        }
}
