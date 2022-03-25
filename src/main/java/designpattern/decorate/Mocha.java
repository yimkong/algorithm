package designpattern.decorate;

/**
 * 2022/3/25
 * desc
 */
public class Mocha extends CondimentDecorator{

    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this. beverage= beverage;
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }

    @Override
    public String getDes() {
        return beverage.getDes()+", Mocha";
    }
}
