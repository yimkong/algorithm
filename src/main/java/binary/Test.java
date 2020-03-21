package binary;

/**
 * author yg
 * description
 * date 2020/3/18
 */
public class Test {
    public static void main(String[] args) {
        int sum = 266;//随便啥数
        int result = ~(sum & 0xFF) + 1;//二进制上0xFF代表8个1,这个意思是取sum二进制上8位数内的二进制进行取反加一,即得到负数
        int negative = ~sum + 1;//二进制的表示上,sum的二进制取反加1则是sum的负数
        System.out.println(result+"=get less than 255 binary part and negative="+result);
        System.out.println(sum + "=negative=" + negative);
        System.out.println("0xFF="+Integer.toBinaryString(0xFF));
    }
}
