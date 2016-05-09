package hash;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rtsy on 11.01.2016.
 */
public class HashMapSpeedTest {
    Map<String, String> liveConfigRules;

    private void buildMapFromFile(long keyCount)
            throws IOException {
        liveConfigRules = new HashMap<String, String>((int) keyCount);
        for (long i = 0; i < keyCount; i++) {
            liveConfigRules.put("key" + i, ""+i);
        }
    }

    @Test
    public void TestReadOnce()
            throws IOException {
        for (int i = 1; i < 100; i++) {
            long size = (long) Math.pow(10, i);
            long start = System.nanoTime();
            buildMapFromFile(size);
            long end = System.nanoTime();
            System.out.printf("BenchMark generation time: %d size: %d\n", (end - start), size);
            String key = "key" + (size - 100);
            start = System.nanoTime();
            int[] reads = {1, 1000, 1000_000, 10_000_000, 100_000_000, 1000_000_000};
            for (int j = 0; j < reads.length; j++) {
                for (int l = 0; l < reads[j]; l++) {
                    liveConfigRules.get(key);
                }
                end = System.nanoTime();
                System.out.printf("benchmark: %d for %d reads.\n",(end - start), reads[j]);
            }
        }
    }
}