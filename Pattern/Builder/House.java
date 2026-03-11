public class House {

    // Required 
    private final int rooms;
    private final int bathrooms;
    private final int bedrooms;


    // Optional
    private final int garage;
    private final int pool;
    private final int backyard;
    private final int basement;

    public House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.bedrooms = builder.bedrooms;
        this.garage = builder.garage;
        this.pool = builder.pool;
        this.backyard = builder.backyard;
        this.basement = builder.basement;
    }


    
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                ", bathrooms=" + bathrooms +
                ", bedrooms=" + bedrooms +
                ", garage=" + garage +
                ", pool=" + pool +
                ", backyard=" + backyard +
                ", basement=" + basement +
                '}';
    } 


}
