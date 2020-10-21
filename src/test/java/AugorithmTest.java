import org.junit.Test;
import problems.*;

/**
 * author yg
 * description
 * date 2019/12/3
 */
public class AugorithmTest {

    @Test
    public void testReverseList() {
        ListNode listNode = ranListNode();
        System.err.println(listNode);
        ListNode listNode1 = ReverseList.solution1(listNode);
        System.err.println(listNode1);
        listNode = ranListNode();
        ListNode listNode2 = ReverseList.solution2(listNode);
        System.err.println(listNode2);
        listNode = ranListNode();
        ListNode listNode3 = ReverseList.solution3(listNode);
        System.err.println(listNode3);
    }

    @Test
    public void testFindTheNode() {
        ListNode listNode = ranListNode();
        System.err.println(listNode);
        ListNode result = FindTheNode.find(listNode, 3);
        ListNode result1 = FindTheNode.find(listNode, 0);
        System.err.println(result);
        System.err.println(result1);
    }

    private ListNode ranListNode() {
        ListNode head = null;
        ListNode temp = null;
        int count = 0;
        while (count++ < 6) {
            if (head == null) {
                head = new ListNode(count);
                temp = head;
            } else {
                temp.next = new ListNode(count);
                temp = temp.next;
            }
        }
        return head;
    }

    @Test
    public void testSimpleArraySum() {
        int[] data = new int[]{2, 5, 6, 1, 4};
        int[] ints = SimpleArraySum.runningSum(data);
        for (int i = 0; i < ints.length; i++) {
            System.err.println(ints[i]);
        }
    }

    @Test
    public void testRearrangeArray(){
        int[] data = new int[]{1,2,3,4,4,3,2,1};
        int[] shuffle = RearrangeArray.shuffle(data, 4);
        for (int i : shuffle) {
            System.err.println(i);
        }
    }

    @Test
    public void test() {
        int i = AccumulateSum.subtractProductAndSum(705);
        System.err.println(i);
    }
}
