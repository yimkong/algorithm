package designpattern.responsibilitychain;

import com.alibaba.fastjson.JSON;
import designpattern.responsibilitychain.impl.Auth1Impl;
import designpattern.responsibilitychain.impl.Auth3Impl;
import designpattern.responsibilitychain.impl.Auth2Impl;

import java.text.ParseException;
import java.util.Date;

/**
 * 2022/3/1
 * desc
 */
public class AuthMain {
    public static void main(String[] args) throws ParseException {
        String orderId = "1234";
        AuthLink authLink = new Auth3Impl("13","职员").appendNext(new Auth2Impl("14","经理").appendNext(new Auth1Impl("15","老板")));
        checkAuth(authLink,orderId);
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date current = sf.parse("2020-06-18 22:49:46");
        //模拟职员审批
        AuthService.auth("13",orderId);
        checkAuth(authLink,orderId);
        //模拟经理审批
        AuthService.auth("14",orderId);
        checkAuth(authLink,orderId);
        //模拟老板审批
        AuthService.auth("15",orderId);
        checkAuth(authLink,orderId);

    }

    //模拟一个员工去检查是否被审批了
    private static void checkAuth(AuthLink authLink, String orderId) {
        System.err.println("开始测试:" + JSON.toJSONString(authLink.doAuth("员工",orderId,new Date())));
    }
}
