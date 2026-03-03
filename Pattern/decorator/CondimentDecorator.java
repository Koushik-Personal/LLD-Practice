package decorator;

public abstract class CondimentDecorator extends Beverages {

    protected Beverages beverage;

    public CondimentDecorator(Beverages beverage) {
        this.beverage = beverage;
    }

    public double getCost() {
        return beverage.getCost();
    }

    public String getDescription() {
        return beverage.getDescription();
    }
}
