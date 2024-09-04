package org.jsp.eventmanagement.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jsp.eventmanagement.dao.EventDao;
import org.jsp.eventmanagement.entity.Event;
import org.jsp.eventmanagement.exceptionclasses.InvalidEventIdException;
import org.jsp.eventmanagement.exceptionclasses.NoEventFoundException;
import org.jsp.eventmanagement.responsestructure.ResponseStructure;
import org.jsp.eventmanagement.service.EventService;
import org.jsp.eventmanagement.util.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao dao;

	@Override
	public ResponseEntity<?> saveEvent(Event event) {
		event.setStatus(EventStatus.UP_COMING);
		int yyyy = Integer.parseInt(("" + event.getFromDateTime()).substring(0, 4));
		int mm = Integer.parseInt(("" + event.getFromDateTime()).substring(5, 7));
		int dd = Integer.parseInt(("" + event.getFromDateTime()).substring(8, 10));
		int hh = Integer.parseInt(("" + event.getFromDateTime()).substring(11, 13));
		int mins = Integer.parseInt(("" + event.getFromDateTime()).substring(14));
		event.setFromDateTime(LocalDateTime.of(yyyy, mm, dd, hh, mins));
		int yyyy1 = Integer.parseInt(("" + event.getToDateTime()).substring(0, 4));
		int mm1 = Integer.parseInt(("" + event.getToDateTime()).substring(5, 7));
		int dd1 = Integer.parseInt(("" + event.getToDateTime()).substring(8, 10));
		int hh1 = Integer.parseInt(("" + event.getToDateTime()).substring(11, 13));
		int mins1 = Integer.parseInt(("" + event.getToDateTime()).substring(14));
		event.setToDateTime(LocalDateTime.of(yyyy1, mm1, dd1, hh1, mins1));
		Event dbEvent = dao.saveEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Saved Successfully...").body(dbEvent).build());
	}

	@Override
	public ResponseEntity<?> findAllEvenrts() {
		List<Event> events = dao.findAllEvents();
		if (events.isEmpty())
			throw NoEventFoundException.builder().message("No Event Present in Databses table").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Event's Found Successfully...").body(events).build());
	}

	@Override
	public ResponseEntity<?> findAllUpCommigEvents() {
//		List<Event> list = dao.findAllEvents();
//		if (list.isEmpty())
//			throw NoEventFoundException.builder().message("No Event Present in Database").build();
//		ArrayList<Event> events = new ArrayList<>();
//		for (Event e : list)
//			if (e.getStatus() == EventStatus.UP_COMING)
//				events.add(e);

		List<Event> events = dao.findEventByEventStatusAsUP_COMMING();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All UP_COMMING Event's Found Successfully...").body(events).build());
	}

	@Override
	public ResponseEntity<?> setStatusToON_GOING(int id) {
		Optional<Event> optional = dao.findEventById(id);
		if (optional.isEmpty())
			throw InvalidEventIdException.builder().message("Unable to Find Event... Invalid Event Id : " + id).build();
		Event event = optional.get();
		event.setStatus(EventStatus.ON_GOING);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Status Changed to ON_GOING Successfully...").body(dao.saveEvent(event)).build());
	}

}
