package vmelnychuk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vmelnychuk.spring.beans.Client;
import vmelnychuk.spring.beans.Event;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Event event = context.getBean("event", Event.class);
        event.setMsg("Hello");
        app.logEvent(event);
    }
    public void logEvent(Event event) {
        eventLogger.logEvent(event);
    }
}
