package drinks;

public class DarkRoastDrink {
    
    String description;
    double cost;

    public DarkRoastDrink() {
        description = "Dark Roast Coffee";
        cost = 0.99;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}
