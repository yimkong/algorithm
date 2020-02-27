package interview.ProducerConsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * author yg
 * description
 * date 2020/2/27
 */
public abstract class ProducerConsumer {
    /**
     * 主线程等待其他线程执行完毕进行计数打印
     */
    private CountDownLatch countDownLatch = new CountDownLatch(6);
    /**
     * 开始执行时间
     */
    protected long begin;
    /**
     * 超时间隔
     */
    protected long timeout;
    /**
     * 总的生产数量
     */
    protected int countProduce;
    /**
     * 总的消费数量
     */
    protected int countConsumer;
    /**
     * 数据列表
     */
    protected final LinkedList<Integer> dataList = new LinkedList<>();

    public void start(long timeout) {
        this.timeout = timeout;
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = newProducer();
            list.add(thread);
        }
        for (int i = 0; i < 3; i++) {
            Thread thread = newConsumer();
            list.add(thread);
        }
        begin = System.currentTimeMillis();
        for (Thread thread : list) {
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用结束,countProduce：" + countProduce + " countConsumer：" + countConsumer);
    }

    protected abstract Thread newConsumer();

    protected abstract Thread newProducer();

    public boolean isTimeOut() {
        return begin + timeout < System.currentTimeMillis();
    }

    public void countConsumer() {
        countConsumer += 1;
    }

    public void countProduce() {
        countProduce += 1;
    }

    public void stopNotify() {
        countDownLatch.countDown();
    }
}
