import java.util.HashMap;
import java.util.Map;

//Observer Pattern
public class DeviceController {
    private static DeviceController instance;
    private Map<String, Device> devices = new HashMap<>();
    private DeviceController() {
        devices.put("alarm", new Alarm());
        devices.put("sprinkler", new Sprinkler());
    }
    public static DeviceController getInstance() {
        if (instance == null) {
            instance = new DeviceController();
        }
        return instance;
    }
    public void activateDevice(String deviceName) {
        Device device = devices.get(deviceName);
        if (device != null) {
            device.turnOn();
        }
    }
    public void deactivateDevice(String deviceName) {
        Device device = devices.get(deviceName);
        if (device != null) {
            device.turnOff();
        }
    }

}
