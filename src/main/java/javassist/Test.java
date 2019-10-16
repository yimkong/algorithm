package javassist;

import java.lang.reflect.Method;

/**
 * author yg
 * description
 * date 2019/10/16
 */
public class Test {
    public static void main(String[] args) {
        TestService testService = new TestService();
        JavassistEnhanser<TestService> testServiceJavassistEnhanser = new JavassistEnhanser<TestService>(testService);
        try {
            Object transform = testServiceJavassistEnhanser.transform(new TestService());
            Method go = transform.getClass().getDeclaredMethod("go", Event.class);
            go.invoke(transform, new Event());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
