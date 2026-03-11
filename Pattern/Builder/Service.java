class Service {
    public static void main(String[] args) {
        
        HouseBuilder builder = new HouseBuilder(0, 0, 0)
                                    .withBackyard(0)
                                    .withBasement(0);
        House house = builder.build();

        System.out.println(house.toString());
    }
}