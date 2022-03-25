package designpattern.decorate;

/**
 * 2022/3/25
 * desc
 */
public class Whip extends CondimentDecorator{
    private final Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .1;
    }

    @Override
    public String getDes() {
        return beverage.getDes() + ", Whip";
    }
}
