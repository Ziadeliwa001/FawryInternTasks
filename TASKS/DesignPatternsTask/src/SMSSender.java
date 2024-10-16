// Adapter Pattern
public class SMSSender {
    private SMSAdapter adapter;
    public SMSSender(SMSAdapter adapter) {
        this.adapter = adapter;
    }
    public void sendSMS(String message) {
        System.out.println(adapter.formatMessage(message));
    }

}
