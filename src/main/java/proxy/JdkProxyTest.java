package proxy;

import proxy.Jdk.Action;
import proxy.Jdk.ActionImpl;
import proxy.Jdk.MyInvoker;

import java.lang.reflect.Proxy;

/**
 * author yg
 * description
 * date 2019/10/11
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        ActionImpl action = new ActionImpl();
        Action o = (Action) Proxy.newProxyInstance(action.getClass().getClassLoader(), action.getClass().getInterfaces(), new MyInvoker(action));
        o.act();
        o.go();
    }
}
