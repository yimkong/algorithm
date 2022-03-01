package designpattern.responsibilitychain;

/**
 * 2022/2/28
 * desc
 */
public class AuthInfo {
    private String code;
    private String info="";

    public AuthInfo(String code, String... info) {
        this.code = code;
        for (String in : info) {
            this.info = this.info.concat(in);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
