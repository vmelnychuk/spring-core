package vmelnychuk.spring.loggers;

import vmelnychuk.spring.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public void logEvent(Event event) {
        for(EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
