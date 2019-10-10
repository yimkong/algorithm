package proxy.Cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author yg
 * description
 * date 2019/10/11
 */
public class ProxyFactory implements MethodInterceptor {
    private final Fighter target;

    public ProxyFactory(Fighter target) {
        this.target = target;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("start");
        method.invoke(target, objects);
        System.err.println("end");
        return null;
    }
}
