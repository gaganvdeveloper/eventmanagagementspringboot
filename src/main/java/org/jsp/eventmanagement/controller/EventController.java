package org.jsp.eventmanagement.controller;

import org.jsp.eventmanagement.entity.Event;
import org.jsp.eventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")




	
public class EventController {

	@Autowired
	private EventService service;
	

	@Operation(summary = "To Create The Event", description = "This API Will Accept The Request body of Event Entity and Persists To The Database table")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Event Saved Sucessfully..."),
			@ApiResponse(responseCode = "400", description = "Unable To Save Event...") })
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody Event event) {
		return service.saveEvent(event);
	}

	

	@Operation(summary = "To Fetch All The Events", description = "This API Will fecth all the Event's Available in The Databases table...")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "All Event's Found Successfully..."),
			@ApiResponse(responseCode = "400", description = "No Event Present in Database table") })
	@GetMapping
	public ResponseEntity<?> findAllEvents() {
		return service.findAllEvenrts();
	}

	@PatchMapping("/ongoing/{id}")
	public ResponseEntity<?> setStatusToON_GOING(@PathVariable int id) {
		return service.setStatusToON_GOING(id);
	}

//	@PatchMapping("/completed/{id}")        				

	@GetMapping("/upcoming")
	public ResponseEntity<?> findAllUpCommigEvents() {
		return service.findAllUpCommigEvents();
	}

//	@GetMapping("/ongoing")

//	@GetMapping("/completed")

}
