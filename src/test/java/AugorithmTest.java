import dynamicprograme.CountCoin;
import dynamicprograme.MinDistance;
import org.junit.Test;
import problems.*;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testLongestCommonPrefix() {
        String[] str = {"flower", "flow", "flight"};
        String[] str1 = {"dog", "racecar", "car"};
        String[] str2 = {"ab", "a"};
//        LongestCommonPrefix.longestCommonPrefix(str2);
        LongestCommonPrefix.longestCommonPrefix1(str1);
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
    public void testRearrangeArray() {
        int[] data = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        int[] shuffle = RearrangeArray.shuffle(data, 4);
        for (int i : shuffle) {
            System.err.println(i);
        }
    }

    @Test
    public void testSubtractProductAndSum() {
        int i = AccumulateSum.subtractProductAndSum(705);
        System.err.println(i);
    }

    @Test
    public void testCreateTargetArray() {
        int[] ints1 = {7, 1, 3, 4, 5};
        int[] ints2 = {0, 3, 2, 4, 4};
        int[] targetArray2 = CreateTargetArray.createTargetArray1(ints1, ints2);
        System.err.println();
    }

    @Test
    public void SumOddLengthSubarrays() {
        SumOddLengthSubarrays.sumOddLengthSubarrays1(new int[]{1, 4, 2, 5, 3});
    }

    @Test
    public void DiagonalSum() {
        int[][] t = new int[3][3];
        t[0] = new int[]{1, 2, 3};
        t[1] = new int[]{4, 5, 6};
        t[2] = new int[]{7, 8, 9};
        DiagonalSum.diagonalSum(t);
        int[][] t1 = new int[1][1];
        t1[0] = new int[]{5};
        DiagonalSum.diagonalSum(t1);
    }

    @Test
    public void SmallerNumbersThanCurrent() {
        int[] res = {8, 1, 2, 2, 3};
        SmallerNumbersThanCurrent.smallerNumbersThanCurrent1(res);
    }

    @Test
    public void getDecimalValue() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(0);
        GetDecimalValue.getDecimalValue2(listNode);
    }

    @Test
    public void calRapidCalculate() {
        RapidCalculate.calculate("AB");
    }

    @Test
    public void balancedStringSplit() {
        BalancedStringSplit.balancedStringSplit("RLRRRLLRLLRLRL");
    }

    @Test
    public void testDeleteMiddleNode() {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        DeleteMiddleNode.deleteNode2(listNode);
        System.err.println(listNode);
    }

    @Test
    public void binaryTreeMaxDepth() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.setLeft(new TreeNode(9));
        TreeNode right = new TreeNode(20);
        treeNode.setRight(right);
        right.setLeft(new TreeNode(15));
        right.setRight(new TreeNode(7));
        BinaryTreeMaxDepth.maxDepth(treeNode);
    }

    @Test
    public void canCompleteCircuitTest() {
        int[] arr1 = {3, 1, 1};
        int[] arr2 = {1, 2, 2};
        CanCompleteCircuit.canCompleteCircuit(arr1, arr2);
    }

    @Test
    public void insertionSortList() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        InsertionSortList.insertionSortList(listNode);
    }

    @Test
    public void replaceElements() {
        int[] arr1 = {17, 18, 5, 4, 6, 1};
        ReplaceElements.replaceElements(arr1);
    }

    @Test
    public void testCountGoodTriplets() {
        int[] arr = {3, 0, 1, 1, 9, 7};
        CountGoodTriplets.countGoodTriplets(arr, 7, 2, 3);
    }

    @Test
    public void testCountCoin() {
        Integer[] arr = {3, 2, 5};
        List<Integer> integers = Arrays.asList(arr);
        int i = CountCoin.countCoin2(integers, 11);
        System.err.println(i);
    }

    @Test
    public void testCountNegatives() {
        int[][] arr = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        int[][] arr = {{4, 3, 2, 1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3},{-1, -1, -2, -3}};
        CountNegatives.countNegatives(arr);
        CountNegatives.countNegatives1(arr);
    }

    @Test
    public void testOddCell() {
        int[][] arr = {{0, 1}, {1, 1}};
        OddCells.oddCells2(2, 3, arr);
    }

    @Test
    public void testMinDistance() {
//        MinDistance.minDistance("horse", "ros");
//        MinDistance.minDistance("a", "ab");
//        MinDistance.minDistance("a", "b");
        MinDistance.minDistance2("distance", "springbok");
    }
}
