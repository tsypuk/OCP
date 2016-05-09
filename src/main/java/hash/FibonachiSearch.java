package hash;

/**
 * Created by rtsy on 13.03.2016.
 */
public class FibonachiSearch {
    public static void main(String[] args) {
        fibonachiTest();
        System.out.println(getFactorial(5));
//        for (int i = 1; i < 100; i ++) {
//            System.out.println(getFibonachiRecursion(i));
//        }
    }

    private static void fibonachiTest() {
        System.out.println(getFibonachiRecursion(6));
        int number = 39088169;
        System.out.println(number + " : " + verifyFibonachiNumer(number));
        number = 1346269;
        System.out.println(number + " : " + verifyFibonachiNumer(number));
        number = 1346267;
        System.out.println(number + " : " + verifyFibonachiNumer(number));
    }

    //    1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946
    private static int getFibonachiRecursion(int value) {
        if (value == 0) {
            throw new IllegalArgumentException(value + " is not supported.");
        } else if (value == 1 || value == 2) {
            return 1;
        }
        return getFibonachiRecursion(value - 2) + getFibonachiRecursion(value - 1);
    }

    private static boolean verifyFibonachiNumer(int number) {
        int index = 0;
        int fibonachi = 0;
        while (fibonachi < number) {
            fibonachi = getFibonachiRecursion(++index);
//            System.out.println(fibonachi);
            if (fibonachi == number) {
                return true;
            }
        }
        return false;
    }

//    1, 1, 2, 6, 24, 120, 720
    private static int getFactorial(int value) {
        if (value <= 1) {
            return 1;
        }
        return value * getFactorial(value - 1);
    }
}