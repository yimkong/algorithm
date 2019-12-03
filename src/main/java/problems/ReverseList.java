package problems;

/**
 * author yg
 * description
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * date 2019/11/30
 */
public class ReverseList {
    //通过俩个指针的方式反转链表顺序
    public static ListNode solution1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            //临时保存下一个点
            tmp = cur.next;
            //改变顺序
            cur.next = pre;
            //俩个指针顺移到下一个点
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //递归
    public static ListNode solution2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = solution2(head.next);
        //对最后一个节点追加节点
        ListNode temp = cur;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        //断掉当前这个节点和下一个节点的关系防止死循环
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    //从最后的栈帧开始理解
    //           head cur
    //    1->2->3->4->5
    //           head cur
    //    1->2->3->4<-5
    //        head    cur
    //    1->2->3->4<-5
    //        head    cur
    //    1->2->3<-4<-5
    //      head      cur
    //    1->2->3<-4<-5
    //      head      cur
    //    1->2<-3<-4<-5
    //   head         cur
    //    1->2<-3<-4<-5
    //   head         cur
    //    1<-2<-3<-4<-5
    public static ListNode solution3(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = solution3(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}
