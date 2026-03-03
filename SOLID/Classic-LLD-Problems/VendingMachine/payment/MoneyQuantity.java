package payment;

public class MoneyQuantity {
    private MoneyType moneyType;
    private int moneyDenomination;
    private int quantity;

    public MoneyQuantity(MoneyType moneyType, int moneyDenomination, int quantity) {
        this.moneyType = moneyType;
        this.moneyDenomination = moneyDenomination;
        this.quantity = quantity;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public int getMoneyDenomination() {
        return moneyDenomination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public void setMoneyDenomination(int moneyDenomination) {
        this.moneyDenomination = moneyDenomination;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}