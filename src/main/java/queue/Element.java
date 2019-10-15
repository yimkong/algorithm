package queue;

import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * author yg
 * description
 * date 2019/10/15
 */
@ToString
public class Element implements Delayed {
    int index;
    int delay;
    final long sequenceNumber;
    static final AtomicLong sequencer = new AtomicLong();

    public Element(int delay) {
        this.delay = delay;
        this.sequenceNumber = sequencer.getAndIncrement();
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
        if (o == this) {
            return 0;
        }
        long delay = o.getDelay(TimeUnit.SECONDS);
        if (this.delay == delay) {
            if (sequenceNumber < ((Element) o).sequenceNumber) {
                return -1;
            } else {
                return 1;
            }
        }
        return this.delay - delay > 0 ? 1 : -1;
    }
}
