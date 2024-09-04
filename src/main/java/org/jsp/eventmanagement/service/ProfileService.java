package org.jsp.eventmanagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {

	ResponseEntity<?> saveProfile(int eid, MultipartFile file);

}
