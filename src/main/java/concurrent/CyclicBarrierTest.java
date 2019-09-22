package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * author yg
 * description
 * 此并发类用处：多线程并发执行并阻塞 当计数到对应数量的线程都await后,执行传入CyclicBarrier的barrierAction，同时唤醒所有正在等待的线程
 * 感觉没啥用 要阻塞很多线程
 * date 2019/9/22
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.err.println(1);
            }
        }).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.err.println(2);
    }

    static class A implements Runnable {

        public void run() {
            System.err.println(3);
        }
    }
}
