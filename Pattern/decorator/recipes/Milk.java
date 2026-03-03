package recipes;

public class Milk extends CondimentDecorator{
    
    public Milk(Beverages beverage) {
        super(beverage);    
    }

    public double getCost() {
        return beverage.getCost() + 0.10;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
