package bio_nio.nio;

import java.io.IOException;

/**
 * author yg
 * description
 * date 2019/12/28
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-001").start();
    }
}
