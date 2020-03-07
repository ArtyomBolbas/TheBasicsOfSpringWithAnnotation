package com.yet.spring.model.logger;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

@Component
public class CacheEventLogger extends FileEventLogger{

	@Value("${cache.size:3}")
	private int cacheSize;
	
	private List<Event> cache;
	
	public CacheEventLogger() {}
	
	public CacheEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<>(cacheSize);
	}
	
	@PostConstruct
	public void initCache() {
		this.cache = new ArrayList<>(cacheSize);
	}
	
	@PreDestroy
	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
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
		cache.stream().forEach(super::logEvent);
	}
	
}
