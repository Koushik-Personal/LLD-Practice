import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import core.VendingMachine;
import inventory.Inventory;
import inventory.Product;
import payment.PaymentManager;
import payment.MoneyQuantity;
import payment.MoneyType;


class Main {

    public static void main(String[] args) {

        Product product1 = new Product("Soda", 1.50);
        Product product2 = new Product("Chips", 1.00);
        Product product3 = new Product("Candy", 0.50);

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(product1, 10);
        products.put(product2, 15);
        products.put(product3, 20);

        MoneyQuantity moneyQuantity1 = new MoneyQuantity(MoneyType.CASH, 10 , 20);
        MoneyQuantity moneyQuantity2 = new MoneyQuantity(MoneyType.CASH, 20 , 10);
        MoneyQuantity moneyQuantity3 = new MoneyQuantity(MoneyType.COINS, 1 , 50);

        HashMap<MoneyQuantity, Integer> payment = new HashMap<>();
        payment.put(moneyQuantity1, 1);
        payment.put(moneyQuantity2, 1);
        payment.put(moneyQuantity3, 1);

        List<MoneyQuantity> paymentList = new ArrayList<>(payment.keySet());

        PaymentManager paymentManager = new PaymentManager(paymentList);


        Inventory inventory = new Inventory(products);

        VendingMachine vendingMachine = new VendingMachine(
            inventory,paymentManager
        );

        System.out.println("Vending Machine initialized successfully.");

        
    }
}