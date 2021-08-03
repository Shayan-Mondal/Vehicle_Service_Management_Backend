package com.capgemini.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorDetails {
	private String messsage;
	private LocalDateTime timestamp;
}
