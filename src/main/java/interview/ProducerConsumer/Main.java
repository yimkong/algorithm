package interview.ProducerConsumer;

/**
 * author yg
 * description 生产者消费者模式
 * date 2020/2/27
 */
public class Main {
    public static int MAX_SIZE = 10;

    public static void main(String[] args) {
        long timeout = 1000 * 60 * 5;
        new ProducerConsumerWithSync().start(timeout);
//        new ProducerConsumerWithCondition().start(timeout);
    }
}
