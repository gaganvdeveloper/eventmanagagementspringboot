package org.jsp.eventmanagement.daoimpl;

import org.jsp.eventmanagement.dao.ProfileDao;
import org.jsp.eventmanagement.entity.Profile;
import org.jsp.eventmanagement.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProfileDaoImpl implements ProfileDao{

	@Autowired
	private ProfileRepository repository;
	
	@Override
	public Profile saveProfile(Profile profile) {
		return repository.save(profile);
	}

}
