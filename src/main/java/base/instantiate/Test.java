package base.instantiate;

/**
 * author yg
 * description 虚拟机规范对象实例化场景
 * 1.new、getstatic、putstatic、invokestatic 四条字节码指令时，会触发初始化，常用场景是：new对象、读取或设置类的静态字段、调用类的静态方法
 * 2.使用java.lang.reflect包反射调用
 * 3.初始化一个类时，父类会先被初始化
 * 4.主类（包含main方法的类）会先被虚拟机初始化
 *
 * date 2020/3/26
 */
public class Test {
    public static void main(String[] args) {
        //子类调用父类的静态属性 父类被初始化 子类没有被初始化
        int value = SubClass.value;
        //通过数组定义来引用类 不会触发类初始化 而是初始化一个 [Lbase.instantiate.SubClass 的类，由虚拟机通过字节码指令newarray生成
        SubClass[] arr = new SubClass[1];
        System.err.println(arr.getClass());
        //final的常量在编译器就存入了调用类Test的常量池，本质上没有引用到该类，因此调用时不会导致初始化
        //该常量SubClass.ID会通过编译期的传播优化存入了Test类的常量池里了，实际上Test类的class文件中并没有SubClass类的符号引用，因此这俩个类编译成class后就没有联系了
        int id = SubClass.ID;
    }
}
