package proxy;

import net.sf.cglib.proxy.Enhancer;
import proxy.Cglib.Fighter;
import proxy.Cglib.ProxyFactory;

/**
 * author yg
 * description
 * date 2019/10/11
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();
        ProxyFactory proxyFactory = new ProxyFactory(fighter);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(fighter.getClass());
        enhancer.setCallback(proxyFactory);
        Fighter o = (Fighter)enhancer.create();
        o.fight();
    }
}
