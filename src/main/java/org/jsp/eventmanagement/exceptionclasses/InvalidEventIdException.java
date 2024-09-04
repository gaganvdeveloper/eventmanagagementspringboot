package org.jsp.eventmanagement.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidEventIdException extends RuntimeException {
	private String message;

	public InvalidEventIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
