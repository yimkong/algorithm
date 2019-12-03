package thread;

/**
 * author yg
 * description 启动两个线程,一个输出1,3,5,7...99,另一个输出2,4,6,8...100,最后STOUT按序输出1,2,3...100
 * date 2019/1/30
 */
public class NotifyAndWait {
    private static final Object obj = new Object();
    private static volatile int i = 1;

    public static void main(String[] args) {

        Thread thr1 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    synchronized (obj) {
                        if (i % 2 != 0) {
                            System.err.println(Thread.currentThread().getName() + ":" + i++);
                            obj.notify();
                        } else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread thr2 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    synchronized (obj) {
                        if (i % 2 == 0) {
                            System.err.println(Thread.currentThread().getName() + ":" + i++);
                            obj.notify();
                        } else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        thr1.start();
        thr2.start();

    }

}
