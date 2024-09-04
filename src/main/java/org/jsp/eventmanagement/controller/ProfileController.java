package org.jsp.eventmanagement.controller;

import org.jsp.eventmanagement.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profiles")
@CrossOrigin(origins = "*")
public class ProfileController {

	@Autowired
	private ProfileService service;

	@PostMapping
	public ResponseEntity<?> saveProfile(@RequestParam int eid, @RequestParam MultipartFile file) {
		return service.saveProfile(eid, file);
	}

}
