//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Sensor smokeSensor = new SmokeSensor();
        Sensor motionSensor = new MotionSensor();

        smokeSensor.detect();
        motionSensor.detect();


        System.out.println("-----------------");

        // Turn off the devices
        DeviceController.getInstance().deactivateDevice("sprinkler");
        DeviceController.getInstance().deactivateDevice("alarm");

    }
}