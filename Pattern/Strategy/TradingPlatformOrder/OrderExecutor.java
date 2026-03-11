public class OrderExecutor {
    
    private OrderExecutionStrategy strategy;
    
    public OrderExecutor(OrderExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OrderExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }

}
