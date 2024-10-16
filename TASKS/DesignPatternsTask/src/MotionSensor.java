// Factory Method Pattern
public class MotionSensor implements Sensor {
    @Override
    public void detect() {
        System.out.println("Motion Sensor Alarm detecting motion");
        DeviceController.getInstance().activateDevice("alarm");

        Logger.getInstance().log("Motion detected.");

        new SMSSender(new SimpleSMSAdapter()).sendSMS("Motion detected!");
    }
}
