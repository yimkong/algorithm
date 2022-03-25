package designpattern.decorate;

/**
 * 2022/3/25
 * desc
 */
public class HouseBlend extends Beverage{
    public HouseBlend(){
        des = "HouseBlend";
    }
    @Override
    public double cost() {
        return .89;
    }
}
