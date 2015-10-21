package vmelnychuk.spring.loggers;

import vmelnychuk.spring.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}
