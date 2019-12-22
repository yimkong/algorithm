package bio_nio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * author yg
 * description
 * date 2019/12/22
 */
public class TimeServerHandler implements Runnable {
    public static final String ORDER = "QUERY TIME ORDER";
    private final Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
            String time, body;
            while (true) {
                body = reader.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("receive order:" + body);
                time = body.equalsIgnoreCase(ORDER) ? new Date().toString() : "BAD ORDER";
                writer.println(time);
            }
        } catch (IOException e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
