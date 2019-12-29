package bio_nio.nio;

/**
 * author yg
 * description
 * date 2019/12/29
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"timeclient-01").start();
    }
}
