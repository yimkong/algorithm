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
    long delay;
    final long sequenceNumber;
    static final AtomicLong sequencer = new AtomicLong();
    int signal;

    public Element(int delay) {
        signal = delay;
        this.delay = System.currentTimeMillis() + delay * 1000;
        this.sequenceNumber = sequencer.getAndIncrement();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return delay- System.currentTimeMillis() ;
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }
        long delay = o.getDelay(TimeUnit.SECONDS);
        long thisDelay = this.getDelay(TimeUnit.SECONDS);
        if (thisDelay == delay) {
            if (sequenceNumber < ((Element) o).sequenceNumber) {
                return -1;
            } else {
                return 1;
            }
        }
        return thisDelay - delay > 0 ? 1 : -1;
    }
}
