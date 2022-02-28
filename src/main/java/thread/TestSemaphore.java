package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2022/2/27
 * desc 控制同时访问的线程数量
 */
public class TestSemaphore {
    static Semaphore semaphore = new Semaphore(5);
    static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        try{
                            System.err.println("yes i am "+ a.getAndIncrement());
                            Thread.sleep(50000);
                        }finally {
                            semaphore.release();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
