package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * author yg
 * description
 * date 2020/11/7
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        completableFutureTest.test();
        completableFutureTest.test();
        completableFutureTest.test();
        completableFutureTest.test();
        completableFutureTest.test();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test() {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread().getName() + ":first");
        }).thenApply((Function) o -> {
            System.err.println(Thread.currentThread().getName() + ":second:" + o);
            return 1;
        }).thenAccept(o -> System.err.println(Thread.currentThread().getName() + ":third"));
    }
}
