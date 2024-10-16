// Factory Method Pattern
public class SmokeSensor implements Sensor {
    @Override
    public void detect() {
        System.out.println("Smoke Sensor detecting smoke");
        // Observer Pattern
        DeviceController.getInstance().activateDevice("sprinkler");

        // Observer Pattern
        Logger.getInstance().log("Smoke detected.");
        new SMSSender(new SimpleSMSAdapter()).sendSMS("Smoke detected!");
    }
}
