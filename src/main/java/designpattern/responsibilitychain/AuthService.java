package designpattern.responsibilitychain;

import dataStructure.HashMap;

import java.util.Date;
import java.util.Map;

/**
 * 2022/2/28
 * desc
 */
public class AuthService {
    private static final Map<String, Date> authMap = new HashMap<>();

    public static Date queryAuth(String uid,String orderId){
        return authMap.get(uid.concat(orderId));
    }

    public static void auth(String uid,String orderId){
        authMap.put(uid.concat(orderId), new Date());
    }
}
