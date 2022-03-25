package designpattern.decorate;

/**
 * 2022/3/25
 * desc 浓缩咖啡
 */
public class Espresso extends Beverage{
    public Espresso(){
        des = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
