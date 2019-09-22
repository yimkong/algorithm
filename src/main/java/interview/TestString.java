package interview;

/**
 * author yg
 * description TODO
 * result:true
 * false
 * date 2019/1/12
 */
public class TestString {
    public static void main(String[] args) {
        String s = "123";
        String s2 = "123";
        String s3 = new String("123");
        String s4 = new String("123");
        System.out.println(s == s2);
        System.out.println(s3);
    }
}


