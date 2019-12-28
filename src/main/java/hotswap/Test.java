package hotswap;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * author yg
 * description
 * date 2019/12/4
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PropertyConfigurator.configure(new Test().getClass().getClassLoader().getResource("log4j.properties").getPath());
        SimpleRunner simpleRunner = new SimpleRunner();
        simpleRunner.run();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            simpleRunner.run();
        }
    }
}
