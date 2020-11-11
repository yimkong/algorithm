package problems;

import lombok.ToString;

/**
 * author yg
 * description
 * date 2019/12/3
 */
@ToString
public class ListNode {
    public int val;
    public ListNode next;

   public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
