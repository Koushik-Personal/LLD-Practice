package inventory;

import java.util.Map;
import java.util.UUID;

public class Inventory {

    private UUID id;
    private Map<Product, Integer> products;


    /*
    * @param products A map of products to their quantities in the inventory.
    * @return A new Inventory object.
    */
    public Inventory(Map<Product, Integer> products) {
        this.id = UUID.randomUUID();
        this.products = products;
    }


    public UUID getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }


}