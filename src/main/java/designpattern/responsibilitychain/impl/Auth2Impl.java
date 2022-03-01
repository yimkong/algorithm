package designpattern.responsibilitychain.impl;

import designpattern.responsibilitychain.AuthInfo;
import designpattern.responsibilitychain.AuthLink;
import designpattern.responsibilitychain.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * 2022/3/1
 * desc
 */
public class Auth2Impl extends AuthLink {

    public Auth2Impl(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uid, String orderId, Date authDate) {
        Date date = AuthService.queryAuth(levelUserId, orderId);
        if(date == null){
            return  new AuthInfo("0001", "orderId:",orderId," 等待二级负责人审批",levelUserName);
        }
        AuthLink next = super.next();
        if (next == null) {
            return new AuthInfo("0000","orderId:",orderId,"二级审批完成","时间:", sf.format(date),"审批人：",levelUserName);
        }
        return next.doAuth(uid,orderId, authDate);
    }
}
