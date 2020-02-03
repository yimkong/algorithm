package bio_nio.aio;

/**
 * author yg
 * description
 * date 2019/12/29
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new Thread(new AsynTimeServerHandler(port), "asyn-server-01").start();
    }
}
