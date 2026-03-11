class Service {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("SMALL" , "THIN").addCheese().addPepperoni().build();

        System.out.println(pizza.toString());
    }
}