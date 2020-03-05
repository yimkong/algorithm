package interview;

/**
 * author yg
 * description 只会抛出一个异常，抛出异常后程序终止
 * result:
 *  Exception in thread "main" java.lang.RuntimeException: b
 * 	at interview.ExceptionTest$A.then(ExceptionTest.java:29)
 * 	at interview.ExceptionTest$A.go(ExceptionTest.java:23)
 * 	at interview.ExceptionTest.main(ExceptionTest.java:13)
 * date 2018/10/20
 */
public class ExceptionTest {

    public static void main(String[] args) {
        new A().go();
    }

    static class A {
        void go() {
            try {
                if (true) {
                    throw new RuntimeException("a");
                }
            } finally {
                then();
            }
        }

        private void then() {
            if (true) {
                throw new RuntimeException("b");
            }
        }
    }
}
