package problems;

/**
 * author yg
 * description 单向链表找到倒数第k个节点
 * date 2020/3/22
 */
public class FindTheNode {
    public static ListNode find(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }
        if (k < 0) {
            return listNode;
        }
        int begin = k - 1;
        ListNode tmp = listNode;
        //找到第k个节点,走k-1步
        for (int i = 0; i < begin; i++) {
            if (tmp.next == null) {//链表长度不够
                return listNode;
            }
            tmp = tmp.next;
        }
        //两个指针同时移动,当右边那个指针到达尾节点的时候，左边那个指针指向的则是目标节点
        while (true) {
            if (tmp.next == null) {
                return listNode;
            }
            tmp = tmp.next;
            listNode = listNode.next;
        }
    }
}
