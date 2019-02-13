package interview;

/**
 * author yg
 * description
 * date 2019/2/13
 */
public class Test {
    public int doS() {
        try {
            System.out.print("1");
            throw new RuntimeException();
        } catch (RuntimeException r) {
            System.out.print("5");
            return 6;
        } catch (Exception e) {
            System.out.print("3");
            return 4;
        }finally {
            System.out.print("7");
            return 8;
        }
    }

    public static void main(String[] args) {
        int i = new Test().doS();
        System.out.print(i);
    }
}
