import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by rtsy on 14.12.2015.
 */
public class LogicTest {

    private Map<List<Boolean>, Boolean> resultsMap = new HashMap<>();

    private static boolean operation1(boolean b1, boolean b2, boolean b3) {
        return b1 & b2 | b3;
    }

    private void generateMapForOper1() {
//        1
        resultsMap.put(Arrays.asList(false, false, false), false);
        resultsMap.put(Arrays.asList(false, false, true), true);
        resultsMap.put(Arrays.asList(false, true, false), false);
        resultsMap.put(Arrays.asList(false, true, true), true);
        resultsMap.put(Arrays.asList(true, false, false), false);
        resultsMap.put(Arrays.asList(true, false, true), true);
        resultsMap.put(Arrays.asList(true, true, false), true);
        resultsMap.put(Arrays.asList(true, true, true), true);
//        8
    }

    private static boolean operationSC(boolean b1, boolean b2, boolean b3) {
        return b1 & b2 || b3;
    }

    private static boolean operationSC2(boolean b1, boolean b2, boolean b3) {
        return b1 && b2 || b3;
    }

    private static boolean operationSC3(boolean b1, boolean b2, boolean b3) {
        return b1 && b2 | b3;
    }

    private static boolean operation1_1(boolean b1, boolean b2, boolean b3) {
        return b2 & b1 | b3;
    }

    private static boolean operation1_2(boolean b1, boolean b2, boolean b3) {
        return b2 && b1 | b3;
    }

    private static boolean operation1_3(boolean b1, boolean b2, boolean b3) {
        return b2 & b1 || b3;
    }

    private static boolean operation1_4(boolean b1, boolean b2, boolean b3) {
        return b2 && b1 || b3;
    }

    private static boolean operation2(boolean b1, boolean b2, boolean b3) {
        return b1 | b3 & b2;
    }

    private static boolean operation2_1(boolean b1, boolean b2, boolean b3) {
        return b1 || b3 & b2;
    }

    private static boolean operation2_2(boolean b1, boolean b2, boolean b3) {
        return b1 || b3 && b2;
    }

    private static boolean operation2_3(boolean b1, boolean b2, boolean b3) {
        return b1 | b3 && b2;
    }

    private void generateMapForOper2() {
//        1
        resultsMap.put(Arrays.asList(false, false, false), false);
        resultsMap.put(Arrays.asList(false, false, true), false);
        resultsMap.put(Arrays.asList(false, true, false), false);
        resultsMap.put(Arrays.asList(false, true, true), true);
        resultsMap.put(Arrays.asList(true, false, false), true);
        resultsMap.put(Arrays.asList(true, false, true), true);
        resultsMap.put(Arrays.asList(true, true, false), true);
        resultsMap.put(Arrays.asList(true, true, true), true);
//        8
    }

    private static boolean operation3(boolean b1, boolean b2, boolean b3) {
//        The first are & operations that are performed
        return b1 | b2 & b3;
    }

    @Test
    public void testOperation1() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation1(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperation1_1() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation1_1(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperation1_2() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation1_2(result.get(0), result.get(1), result.get(2))));
    }
    @Test
    public void testOperation1_3() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation1_3(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperation1_4() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation1_4(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperationSC() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operationSC(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperationSC2() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operationSC2(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOperationSC3() {
        resultsMap.clear();
        generateMapForOper1();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operationSC3(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOpertaion2() {
        resultsMap.clear();
        generateMapForOper2();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation2(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOpertaion2_1() {
        resultsMap.clear();
        generateMapForOper2();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation2_1(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOpertaion2_2() {
        resultsMap.clear();
        generateMapForOper2();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation2_2(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOpertaion2_3() {
        resultsMap.clear();
        generateMapForOper2();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation2_3(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void testOpertaion3() {
        resultsMap.clear();
        generateMapForOper2();
        resultsMap.forEach(
                (result, booleanResult) -> assertEquals(booleanResult, operation3(result.get(0), result.get(1), result.get(2))));
    }

    @Test
    public void test() {
        resultsMap.clear();
        generateMapForOper2();
        for (Map.Entry<List<Boolean>, Boolean> entry : resultsMap.entrySet()) {
            System.out.println(entry);
            System.out.println(String.format("Result = %b, operands %b %b %b", entry.getValue(), entry.getKey().get(0), entry.getKey().get(1), entry.getKey().get(2)));
            assertEquals(entry.getValue(), operation2_3(entry.getKey().get(0), entry.getKey().get(1), entry.getKey().get(2)));
        }
    }
}