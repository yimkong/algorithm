package study;

/**
 * author yg
 * description 最大公约数
 * date 2020/3/21
 */
public class HighestCommonFactor {
    public static void main(String[] args) {
//        System.out.println(gcd(5, 8));
//        System.out.println(gcd(12, 20));
        System.out.println(gcd(78, 56));
    }

    //欧几里得算法(辗转相除法):两个整数的最大公约数等于其中较小的数和两数相除余数的最大公约数
    //如果p<q 则通过第一次递归，使得下次递归恢复p>q的顺序
    //如果p==q 则俩次递归就结束
    //如果p>q 则直接按照辗转相除法继续计算直到可以整除为止
    public static int gcd(int p, int q) {
        //如果上一次递归的余数是零，则返回上次递归的除数
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
