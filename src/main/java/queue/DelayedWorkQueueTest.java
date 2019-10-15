package queue;

/**
 * author yg
 * description
 * date 2019/10/15
 */
public class DelayedWorkQueueTest {
    DelayedWorkQueue queue = new DelayedWorkQueue();

    public static void main(String[] args) throws InterruptedException {
        DelayedWorkQueueTest delayedWorkQueueTest = new DelayedWorkQueueTest();
        DelayedWorkQueue queue = delayedWorkQueueTest.queue;
        queue.offer(new Element(10));
        queue.offer(new Element(5));
        queue.offer(new Element(7));
//        System.err.println(queue);
        queue.offer(new Element(14));
//        System.err.println(queue);
        queue.offer(new Element(12));
//        System.err.println(queue);
        System.err.println(queue.take());
        System.err.println(queue.take());
        System.err.println(queue.take());
        System.err.println(queue.take());
        System.err.println(queue.take());
    }
}
