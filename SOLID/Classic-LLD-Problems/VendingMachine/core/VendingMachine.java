package core;

import inventory.Inventory;
import payment.MoneyType;
import payment.PaymentManager;

public class VendingMachine {

    private MachineState state;
    private Inventory inventory;
    private PaymentManager paymentManager;
    private double currentBalance;
    
    public VendingMachine(Inventory inventory, PaymentManager paymentManager) {
        this.state = MachineState.IDLE;
        this.inventory = inventory;
        this.paymentManager = paymentManager;
        this.currentBalance = 0.0;
    }

    public MachineState getState() {
        return state;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void insertMoney( MoneyType moneyType, int denomination, int quantity ) {
        
       
    }


}