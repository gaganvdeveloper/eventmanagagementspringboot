package org.jsp.eventmanagement.service;

import org.jsp.eventmanagement.entity.Event;
import org.springframework.http.ResponseEntity;

public interface EventService {

	ResponseEntity<?> saveEvent(Event event);

	ResponseEntity<?> findAllEvenrts();

	ResponseEntity<?> findAllUpCommigEvents();

	ResponseEntity<?> setStatusToON_GOING(int id);

	
	
	
}
