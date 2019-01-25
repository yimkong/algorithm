import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.BubbleSort;

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
    public void test() {
        int[] ints = getRandomArray();
        BubbleSort.sort(ints);
        check(ints);
    }

    private int[] getRandomArray() {
        int[] ints = {3, 2, 6, 1, 2, 3, 10, -1};
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
