public class Alarm implements Device {
    @Override
    public void turnOn() {
        System.out.println("Alarm turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Alarm turned OFF");
    }
}
