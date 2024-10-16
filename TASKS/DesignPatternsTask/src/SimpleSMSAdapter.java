public class SimpleSMSAdapter implements SMSAdapter {
    @Override
    public String formatMessage(String message) {
        return "SMS: " + message;
    }
}
