package recipes;

public class Soy extends CondimentDecorator {
    String description;
    double cost;

    public Soy(Beverages beverage) {
        super(beverage);
        cost = 0.15;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
}
