package designpattern.decorate;

/**
 * 2022/3/25
 * desc 装饰者模式
 */
public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDes()+" $"+beverage.cost());
        beverage = new Whip(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDes()+" $"+beverage.cost());

        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDes()+" $"+houseBlend.cost());
    }
}
