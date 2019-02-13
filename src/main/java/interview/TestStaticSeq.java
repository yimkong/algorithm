package interview;

/**
 * author yg
 * description result:静态代码块优先执行
 * init seq b
 * init seq d
 * init seq a
 * init seq c
 * init seq a
 * init seq c
 * init seq e
 * date 2019/1/12
 */
public class TestStaticSeq {
    {
        System.out.println("init seq a");
    }

    static {
        System.out.println("init seq b");
    }

    public TestStaticSeq() {
        System.out.println("init seq c");
    }

    public static void main(String[] args) {
        System.out.println("init seq d");
        new TestStaticSeq();
        new TestStaticSeq();
        System.out.println("init seq e");
    }
}


