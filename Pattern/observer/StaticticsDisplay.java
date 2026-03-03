public class StaticticsDisplay implements Observer, Display {
    
    float temp;
    float humidity;
    float pressure;

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }


    // This will measure the average temp, humidity and pressure
    @Override
    public void display() {


        System.out.println("StaticticsDisplay:" + temp + " " + humidity + " " + pressure);
    }


}