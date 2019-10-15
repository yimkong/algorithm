package queue;

import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * author yg
 * description
 * date 2019/10/15
 */
@ToString
public class Element implements Delayed {
    int index;
    int delay;

    public Element(int delay) {
        this.delay = delay;
    }

    public int compareTo(Element o2) {
        return index - o2.index;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return delay;
    }

    @Override
    public int compareTo(Delayed o) {
        long delay = o.getDelay(TimeUnit.SECONDS);
        if (this.delay == delay) {
            return 0;
        }
        return this.delay - delay > 0 ? 1 : -1;
    }
}
