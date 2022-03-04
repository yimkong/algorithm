package reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean a = new AtomicBoolean(false);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                       a.set(!a.get());
                }
            }
        });
         thread.start();
        while (true) {
            Thread.sleep(5000);
            System.err.println(a.get()+"-"+thread.getState().name());
        }
    }
}
