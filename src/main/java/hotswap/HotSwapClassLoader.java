package hotswap;

/**
 * author yg
 * description
 * date 2019/12/4
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> findClass(byte[] b) {
        return this.defineClass(null, b, 0, b.length);
    }
}
