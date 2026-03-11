public class OrderStrategyFactory {

    public static OrderExecutionStrategy getStrategy( OrderType type) {

        switch (type) {
            case STOPLOSS:
                return new StopLossOrderStrategy();    
            case LIMIT:
                return new LimitOrderStrategy();
            case MARKET:
                return new MarketOrderStrategy();
            default:
                throw new IllegalArgumentException("Invalid order type");
        }
    }
}
