package vmelnychuk.spring.loggers;

import vmelnychuk.spring.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    public ConsoleEventLogger() {
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
