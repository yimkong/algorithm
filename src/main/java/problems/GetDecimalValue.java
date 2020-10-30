package problems;

import java.util.ArrayList;

/**
 * author yg
 * description
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * date 2020/10/30
 */
public class GetDecimalValue {
    public static int getDecimalValue(ListNode head) {
        ArrayList<Integer> objects = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            objects.add(node.val);
            node = node.next;
        }
        int size = objects.size();
        int twoValue = 1;
        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            Integer cur = objects.get(i);
            sum += cur * twoValue;
            twoValue *= 2;
        }
        return sum;
    }
    public static int getDecimalValue2(ListNode head) {
        int res = 0;
        while(head != null){
            res = res * 2 + head.val;//精妙！从高位到地位开始遍历，把从高位得到的结果每遍历一次乘以2，意识是把每个二进制数按照高度乘以2累乘，高度越高乘以2的次数越多
            head = head.next;
        }
        return res;
    }
}
