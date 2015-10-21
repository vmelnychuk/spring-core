package vmelnychuk.spring.loggers;

import vmelnychuk.spring.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private List<Event> cache;
    private int cacheSize;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cache = new ArrayList<Event>();
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for(Event event : cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if(!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
