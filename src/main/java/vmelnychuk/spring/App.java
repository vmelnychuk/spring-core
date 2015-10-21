package vmelnychuk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vmelnychuk.spring.beans.Client;
import vmelnychuk.spring.beans.Event;
import vmelnychuk.spring.loggers.ConsoleEventLogger;
import vmelnychuk.spring.loggers.EventLogger;

import java.util.Random;

public class App {
    public static final int EVENTS_NUMBER = 20;
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        for(int i = 0; i < EVENTS_NUMBER; i++) {
            Event event = context.getBean("event", Event.class);
            event.setMsg(String.valueOf(new Random().nextBoolean()));
            app.logEvent(event);
        }
        context.close();
    }
    public void logEvent(Event event) {
        eventLogger.logEvent(event);
    }
}
