public class Pizza {
    
    private final String size;
    private final String dough;

    // Optional
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean olives;
    private final boolean extraSauce;


    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.dough = builder.dough;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.olives = builder.olives;
        this.extraSauce = builder.extraSauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", dough=" + dough +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                ", olives=" + olives +
                ", extraSauce=" + extraSauce +
                '}';
    }


    public static class PizzaBuilder {

        private String size;
        private String dough;

        // Optional
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean olives;
        private boolean extraSauce;


        public PizzaBuilder( String size , String dough ) {
            this.size = size;
            this.dough = dough;
        }
        
        
        public PizzaBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }       

        public PizzaBuilder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public PizzaBuilder addOlives() {
            this.olives = true;
            return this;
        }

        public PizzaBuilder addExtraSauce() {
            this.extraSauce = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }


    }


}
