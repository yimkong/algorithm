import books.algs4.Shell;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.BubbleSort;
import sort.MergeSort;
import sort.QuitSort;
import sort.SelectionSort;

import java.util.Random;

/**
 * author yg
 * description
 * date 2019/1/25
 */
public class SortTest {

    @Before
    public void before() {

    }

    @Test
    public void testBubble() {
        int[] ints = getRandomArray();
        BubbleSort.sort(ints);
        check(ints);
    }

    @Test
    public void testSelection() {
        int[] ints = getRandomArray();
        SelectionSort.sort(ints);
        check(ints);
    }

    @Test
    public void testMerge() {
        int[] ints = getRandomArray();
        int[] sort = MergeSort.sort(ints);
        check(sort);
    }

    @Test
    public void quitSort() {
        int[] ints = getRandomArray();
        QuitSort.sort(ints);
        check(ints);
    }

    @Test
    public void shellTest() {
        int[] randomArray = getRandomArray();
        Integer[] res = new Integer[randomArray.length];
        for (int i = 0; i < randomArray.length; i++) {
            res[i] = randomArray[i];
        }
        Shell.sort(res);
    }

    private int[] getRandomArray() {
        Random random = new Random();
        int length = random.nextInt(5) + 10;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = random.nextInt(15) - 6;
        }
        System.err.println(JSONObject.toJSONString(ints));
        return ints;
    }

    private void check(int[] ints) {
        System.err.println(JSONObject.toJSON(ints));
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            Assert.assertTrue("排序错误", temp <= ints[i]);
            temp = ints[i];
        }
    }
}
