public class ThirdPartyDisplay implements Observer , Display {

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("ThirdPartyDisplay:" + temp + " " + humidity + " " + pressure);
    }

    @Override
    public void display() {
        System.out.println("ThirdPartyDisplay");
    }

}