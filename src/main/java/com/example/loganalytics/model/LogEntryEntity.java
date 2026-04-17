package com.example.loganalytics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntryEntity {
	private long timestamp;
    private String level;
    private String message;
}
