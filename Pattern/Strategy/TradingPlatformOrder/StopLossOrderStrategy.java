public class StopLossOrderStrategy implements OrderExecutionStrategy {
    @Override
    public void execute() {
        System.out.println("Executing stop loss order strategy");
    }

}
