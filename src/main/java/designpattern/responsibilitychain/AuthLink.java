package designpattern.responsibilitychain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2022/2/28
 * desc
 */
public abstract class AuthLink {

    protected SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected String levelUserId;
    protected String levelUserName;
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next(){
        return next;
    }

    public AuthLink appendNext(AuthLink authLink){
        this.next = authLink;
        return this;
    }

    public abstract AuthInfo doAuth(String uid,String orderId, Date authDate);
}
