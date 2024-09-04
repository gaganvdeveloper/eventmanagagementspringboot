package org.jsp.eventmanagement.repository;

import java.util.List;

import org.jsp.eventmanagement.entity.Event;
import org.jsp.eventmanagement.util.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByStatus(EventStatus upComing);

}
