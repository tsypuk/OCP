package ocp7.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by rtsy on 14.10.2015.
 */
public class ResourceBundles {
    public static void main(String[] args)
            throws InterruptedException {
        ResourceBundle rb = ResourceBundle.getBundle("ocp7.chapter8.news");
        if (rb.containsKey("author")) {
            System.out.println(rb.getString("author"));
        }
        List<String> li = new ArrayList<>();
        Random random = new Random();
        int i = 0;
//        Lets connect to this process from JVVM
        Thread.sleep(5000);

        while (true) {
//            i++;
            Thread.sleep(500);
            li.add(new String("messageID:" + random.nextInt(100_000)));
            System.out.println(li.size());
//            if (i % 50000 == 0) {
//                Thread.sleep(1000);
//            }
        }
    }
}