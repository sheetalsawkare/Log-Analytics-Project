package com.example.loganalytics.service;

import java.util.ArrayDeque;

import org.springframework.stereotype.Component;

import com.example.loganalytics.model.LogEntryEntity;

@Component
public class LogService {
	
	private final ArrayDeque<LogEntryEntity> deque = new ArrayDeque<>();
	private final long WINDOW_SIZE = 60 * 1000;
	
	public synchronized void addLog(LogEntryEntity newLog) {
		newLog.setTimestamp(System.currentTimeMillis());
		long now = System.currentTimeMillis();
		
		deque.addLast(newLog);
		
		while(!deque.isEmpty() && now - deque.peekFirst().getTimestamp() > WINDOW_SIZE) {
			deque.removeFirst();
		}	
	}
	
	public synchronized int totalLogs() {
		return deque.size();
	}
	
	public synchronized int getErrorCount() {
		int count = 0;
		for(LogEntryEntity log : deque) {
			if("ERROR".equals(log.getLevel())) {
				count++;
			}
		}
		return count;
	}
	
	public synchronized boolean isTrafficSpike() {
	    return deque.size() > 100;
	}
	
	public synchronized double getErrorRate() {
	    if (deque.isEmpty()) return 0.0;

	    int errors = 0;

	    for (LogEntryEntity log : deque) {
	        if ("ERROR".equalsIgnoreCase(log.getLevel())) {
	            errors++;
	        }
	    }

	    return (errors * 100.0) / deque.size();
	}
	
	
}
