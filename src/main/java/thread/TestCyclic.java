package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 2022/2/27
 * desc 实现让一组线程都等待某个状态再一起执行
 */
public class TestCyclic {
    public static void main(String[] args) {
        int count = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for (int i = 0; i < 10; i++) {
            new Writer(cyclicBarrier, i).start();
        }

    }
}

class Writer extends Thread {

    private final CyclicBarrier cyclicBarrier;
    private final int i;

    public Writer(CyclicBarrier cyclicBarrier, int i) {
        this.cyclicBarrier = cyclicBarrier;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(i * 1000L);
            System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
            cyclicBarrier.await();
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
