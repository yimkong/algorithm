package interview.ProducerConsumer;

/**
 * author yg
 * description 通过对象锁以及wait/notify实现
 * date 2020/2/27
 */
public class ProducerConsumerWithSync extends ProducerConsumer {

    public Thread newConsumer() {
        return new Consumer0();
    }

    public Thread newProducer() {
        return new Producer0();
    }

    class Consumer0 extends Thread {

        @Override
        public void run() {
            while (!isTimeOut()) {
                synchronized (dataList) {
                    while (dataList.size() == 0) {
                        try {
                            dataList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = dataList.poll();
                    countConsumer();
                    System.out.println(Thread.currentThread() + ":消费:" + poll);
                    dataList.notify();
                }
            }
            stopNotify();
        }
    }

    class Producer0 extends Thread {

        @Override
        public void run() {
            while (!isTimeOut()) {
                synchronized (dataList) {
                    while (dataList.size() == Main.MAX_SIZE) {
                        try {
                            dataList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int e = dataList.size() + 1;
                    dataList.add(e);
                    countProduce();
                    System.out.println(Thread.currentThread() + ":生成:" + e);
                    dataList.notify();
                }
            }
            stopNotify();
        }
    }
}
