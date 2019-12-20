package hotswap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author yg
 * description
 * date 2019/12/4
 */
public class SimpleRunner {
    long time = System.currentTimeMillis();
    void run() {
        System.err.println(System.currentTimeMillis());
        ArrayList<Long> objects = new ArrayList<>();
        objects.add(time);
        System.err.println(objects);
        List<Long> collect = objects.stream().filter(x -> x > 1).collect(Collectors.toList());
        System.err.println(collect);
    }

//    void run() {
//        System.err.println(2);
//    }
}
