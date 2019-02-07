package thread.lockCondition;

/**
 * author yg
 * description
 * date 2019/2/7
 */
public class Main {
    public static final int limit = 100;

    public static void main(String[] args) {
        final ProductQueue<Integer> integerProductQueue = new ProductQueue<Integer>();
        Thread producer = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                try {
                    while (i < limit) {
                        integerProductQueue.put(i++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                try {
                    while (i < limit) {
                        Integer take = integerProductQueue.take();
                        System.err.println("取出:" + take);
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
