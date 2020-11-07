package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * author yg
 * description
 * date 2020/11/7
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
        completableFutureTest.test2();
        completableFutureTest.test3();
    }

    private void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> illegal = CompletableFuture.supplyAsync(() -> Integer.parseInt("ILLEGAL"))
                .thenApply(r -> r * 2 * Math.PI)
                .thenApply(s -> "apply>>" + s)
                .exceptionally(ex -> "Error:" + ex.getMessage());
        System.err.println(illegal.get());
    }

    private void test2() {
        //多个并发函数组合并join入主线程得到结果
        String join = CompletableFuture.supplyAsync(() -> "hello").thenCombine(CompletableFuture.supplyAsync(() -> "world"), (s1, s2) -> s1 + " " + s2).join();
        System.err.println(join);
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
