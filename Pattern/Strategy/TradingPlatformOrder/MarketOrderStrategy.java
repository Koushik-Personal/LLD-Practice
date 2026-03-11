public class MarketOrderStrategy implements OrderExecutionStrategy {
    MarketOrderStrategy() {}

    @Override
    public void execute() {
        System.out.println("Executing market order strategy");
    }

    
}
