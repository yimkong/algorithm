package proxy.Jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author yg
 * description
 * date 2019/10/11
 */
public class MyInvoker implements InvocationHandler {

    private final ActionImpl action;

    public MyInvoker(ActionImpl action) {
        this.action=action;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("before");
        method.invoke(action, args);
        System.err.println("after");
        return null;
    }
}
