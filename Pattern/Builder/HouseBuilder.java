public class HouseBuilder { 
    
// Required 
    int rooms;
    int bathrooms;
    int bedrooms;


    // Optional
    int garage;
    int pool;
    int backyard;
    int basement;


    public HouseBuilder(int rooms, int bathrooms, int bedrooms) {
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
    }


    public HouseBuilder withGarage( int garage) {
        this.garage = garage;
        return this;
    }
    public HouseBuilder withPool( int pool) {
        this.pool = pool;
        return this;
    }
    public HouseBuilder withBackyard( int backyard) {
        this.backyard = backyard;
        return this;
    }
    public HouseBuilder withBasement( int basement) {
        this.basement = basement;
        return this;
    }


    public House build() {
        return new House(this);
    }

}
