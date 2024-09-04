package org.jsp.eventmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.eventmanagement.entity.Event;

public interface EventDao {

	Event saveEvent(Event event);

	Event updateEvent(Event event);

	List<Event> findAllEvents();
	
	Optional<Event> findEventById(int id);

	List<Event> findEventByEventStatusAsUP_COMMING();

}
