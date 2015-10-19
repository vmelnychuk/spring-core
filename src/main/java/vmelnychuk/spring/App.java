package vmelnychuk.spring;

import vmelnychuk.spring.beans.Client;
import vmelnychuk.spring.loggers.ConsoleEventLogger;
import vmelnychuk.spring.loggers.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        App app = new App(new Client("1", "John Smith"), new ConsoleEventLogger());
        app.logEvent("Some event from user 1");
    }
    public void logEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }
}
