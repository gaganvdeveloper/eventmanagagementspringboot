package org.jsp.eventmanagement.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.eventmanagement.dao.EventDao;
import org.jsp.eventmanagement.entity.Event;
import org.jsp.eventmanagement.repository.EventRepository;
import org.jsp.eventmanagement.util.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private EventRepository repository;

	@Override
	public Event saveEvent(Event event) {
		return repository.save(event);
	}
	
	@Override
	public Event updateEvent(Event event) {
		return repository.save(event);
	}

	@Override
	public List<Event> findAllEvents() {
		return repository.findAll();
	}

	@Override
	public Optional<Event> findEventById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Event> findEventByEventStatusAsUP_COMMING() {
		return repository.findByStatus(EventStatus.UP_COMING);
	}

}
