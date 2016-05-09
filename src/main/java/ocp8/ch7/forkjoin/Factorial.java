package ocp8.ch7.forkjoin;

/**
 * Created by rtsy on 21.02.2016.
 */
public class Factorial {
    public static int factorial(int n) {
        //Base case: non-recursion method to terminate the recursive path
        if (n <= 1) return 1;
        //Recursion case:
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            System.out.println("Factorial: " + i + " = " + factorial(i));
        }
    }
}
