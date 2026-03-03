package payment;
import java.util.List;

public class PaymentManager {

    private final List<MoneyQuantity> moneyQuantities;

    public PaymentManager(List<MoneyQuantity> moneyQuantities) {
        this.moneyQuantities = moneyQuantities;
    }

    public List<MoneyQuantity> getMoneyQuantities() {
        return moneyQuantities;
    }


    /**
     * Replaces the current list of money quantities with the given list.
     * 
     * @param newMoneyQuantities the new list of money quantities
     * @return true if the replacement was successful, false otherwise
     */
    public boolean setMoneyQuantities(List<MoneyQuantity> newMoneyQuantities) {
        if (newMoneyQuantities == null || newMoneyQuantities.isEmpty()) {
            return false;
        }
        moneyQuantities.clear();
        moneyQuantities.addAll(newMoneyQuantities);
        return true;
    }

    
    /**
     * Check if the payment is sufficient by comparing it with the available money quantities.
     * 
     * @param payment the payment to check
     * @return true if the payment is sufficient, false otherwise
    */
    public boolean isPaymentSufficient(MoneyQuantity payment) {
        for (MoneyQuantity mq : this.moneyQuantities) {
            if (mq.getMoneyType().equals(payment.getMoneyType()) &&
                    mq.getMoneyDenomination() >= payment.getMoneyDenomination()) {
                return true;
            }
        }
        return false;
    }

}