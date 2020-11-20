package problems;

/**
 * author yg
 * description
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/11/20
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        //断掉第一个节点
        ListNode first = head;//新的节点的第一个节点
        ListNode begin = head.next;//旧的节点的临时的每个节点
        head.next = null;
        ListNode lastSorted = first;
        while (begin != null) {
            //提高效率,直接判断最后那个节点
            if (lastSorted.val <= begin.val) {
                lastSorted.next = begin;
                lastSorted = begin;
                ListNode temp = begin.next;
                begin.next = null;
                begin = temp;
                continue;
            }
            //开始移动第二个节点
            ListNode temp = first;
            if (begin.val <= temp.val) {
                ListNode next = begin.next;
                begin.next = first;
                first = begin;
                begin = next;
                continue;
            }
            while (temp.next != null && begin.val >= temp.next.val) {//找到最合适的那个节点往后插入新的节点
                temp = temp.next;
            }
            ListNode next = begin.next;
            begin.next = null;
            if (temp.next != null) {
                begin.next = temp.next;
            } else {
                lastSorted = begin;
            }
            temp.next = begin;
            begin = next;
        }
        return first;
    }
}
