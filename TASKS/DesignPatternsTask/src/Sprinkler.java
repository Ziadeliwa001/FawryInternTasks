public class Sprinkler implements Device{
    @Override
    public void turnOn() {
        System.out.println("Sprinkler turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Sprinkler turned OFF");
    }
}
