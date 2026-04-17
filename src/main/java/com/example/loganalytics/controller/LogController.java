package com.example.loganalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loganalytics.model.LogEntryEntity;
import com.example.loganalytics.service.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {
	
	@Autowired
	LogService service;
	
	@PostMapping
	public String addLog(@RequestBody LogEntryEntity log) {
		service.addLog(log);
		return "log added";
	}
	
	@GetMapping("/count")
	public int totalLogs() {
		return service.totalLogs();
		
	}
	
	@GetMapping("/errors")
	public int getErrorCount() {
		return service.getErrorCount();
	}
	
	@GetMapping("/error-rate")
	public double errorRate() {
	    return service.getErrorRate();
	}
	
	@GetMapping("/spike")
	public boolean spike() {
	    return service.isTrafficSpike();
	}
}
