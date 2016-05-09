package hash;


/**
 * Created by rtsy on 23.12.2015.
 */
public class HashTest {

    public static void main(String[] args) {
       for (int i = 0; i < 100; i++) {
//           >>>1 division by 2^1=2
//           System.out.println(i + ": " + (i >>>1));
//           division by 2^2=4
//           System.out.println(i + ": " + (i >>>2));
           //           division by 2^4=16
//           System.out.println(i + ": " + (i >>>4));

           int j = i;
           System.out.println(Integer.toBinaryString(i));
           System.out.println("|");
           System.out.println(Integer.toBinaryString(j>>>1));
           int s = (j |= j>>>1);
           System.out.println("--------------");
           System.out.println(Integer.toBinaryString(s));
           System.out.println(i + " : " + s);
           System.out.println("=======");
           System.out.println("=======");
       }
    }

    public static int hashFunc(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
