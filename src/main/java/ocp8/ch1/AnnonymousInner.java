package ocp8.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roman.tsypuk on 6/18/16.
 * inner class that does not have name
 * Required to extend and existing class or implement an existing in
 */
public class AnnonymousInner {
    abstract class SaleTodayOnly {
        abstract int dollarsOdd();
    }

    interface SaleTodayInter {
        int dollarsOdd();
    }

    public void doStaff(int basePrice) {
//        1. Anonymous inner class
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            int dollarsOdd() {
                return 5;
            }
        }; //   This is declaration of new local variable - so semicolom is requiered.
        sale.dollarsOdd();
//       2. Anonymous inner implementation
        SaleTodayInter saleTodayInter = new SaleTodayInter() {
            @Override
            public int dollarsOdd() {
                return 13;
            }
        };
        saleTodayInter.dollarsOdd();
    }

    public int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice + sale.dollarsOdd();
    }

    public int pay() {
//        3. Define right in the argument to another method
        return admission(100, new SaleTodayOnly() {
            @Override
            int dollarsOdd() {
                return 15;
            }
        });
    }

    public static void main(String[] args) {
        AnnonymousInner annonynousInner = new AnnonymousInner();
        annonynousInner.pay();
//        Another example of anonymous inner class
        List<String> arrayList = new ArrayList<String>(Arrays.asList("1", "2", "3")) {
            @Override
            public int size() {
                return 5;
            }
        };
        System.out.println(arrayList.size());
    }
}