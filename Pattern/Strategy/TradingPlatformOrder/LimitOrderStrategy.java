public class LimitOrderStrategy implements OrderExecutionStrategy{
    LimitOrderStrategy() {}

    @Override
    public void execute() {
        System.out.println("Executing limit order strategy");
    }

    
}
