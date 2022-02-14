package thread.testjoinforkpool;

import java.util.concurrent.ForkJoinPool;

public class Test0 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(3), new TreeNode(2, new TreeNode(2), new TreeNode(8)));
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer invoke = forkJoinPool.invoke(new CountingTask(treeNode));
        System.err.println(invoke);
    }
}
