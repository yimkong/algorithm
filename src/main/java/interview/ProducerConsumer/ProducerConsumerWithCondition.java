package interview.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author yg
 * description 通过使用condition的await/signal
 * date 2020/2/27
 */
public class ProducerConsumerWithCondition extends ProducerConsumer {
    private Lock obj = new ReentrantLock();
    private Condition notEmpty = obj.newCondition();
    private Condition notFull = obj.newCondition();

    @Override
    protected Thread newConsumer() {
        return new Consumer();
    }

    @Override
    protected Thread newProducer() {
        return new Producer();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            obj.lock();
            try {
                while (!isTimeOut()) {
                    while (dataList.size() == Main.MAX_SIZE) {
                        notFull.await();
                    }
                    int e = dataList.size() + 1;
                    dataList.add(e);
                    System.out.println(Thread.currentThread() + ":生成:" + e);
                    countProduce();
                    notEmpty.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                obj.unlock();
            }
            stopNotify();
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            obj.lock();
            try {
                while (!isTimeOut()) {
                    while (dataList.size() == 0) {
                        notEmpty.await();
                    }
                    Integer poll = dataList.poll();
                    System.out.println(Thread.currentThread() + ":消费:" + poll);
                    countConsumer();
                    notFull.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                obj.unlock();
            }
            stopNotify();
        }
    }
}
