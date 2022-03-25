package designpattern.decorate;

/**
 * 2022/3/25
 * desc 饮料
 */
public abstract class Beverage {
    protected String des = "Unknown beverage";

    public String getDes() {
        return des;
    }
    public abstract double cost();
}
