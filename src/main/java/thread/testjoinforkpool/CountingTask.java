package thread.testjoinforkpool;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountingTask extends RecursiveTask<Integer> {

    private final TreeNode node;

    public CountingTask(TreeNode node) {
        this.node = node;
    }

    @Override
    protected Integer compute() {
        return node.value+ node.childern.stream().map(x -> new CountingTask(x).fork()).mapToInt(ForkJoinTask::join).sum();
    }
}
