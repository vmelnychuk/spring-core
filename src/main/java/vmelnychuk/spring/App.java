package vmelnychuk.spring;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;
    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event from user 1");
    }
    public void logEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }
}
