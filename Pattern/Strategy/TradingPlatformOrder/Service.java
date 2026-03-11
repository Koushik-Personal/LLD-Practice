class Service {
    public static void main(String[] args) {

        OrderExecutor executor = new OrderExecutor(OrderStrategyFactory.getStrategy(OrderType.LIMIT));
        executor.execute();

        executor = new OrderExecutor(OrderStrategyFactory.getStrategy(OrderType.STOPLOSS));
        executor.execute();

        executor = new OrderExecutor(OrderStrategyFactory.getStrategy(OrderType.MARKET));
        executor.execute();
        
    }
}