package com.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webapp.repository.RegistrationRepository;
import com.webapp.entity.Registration;
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public void addRegistration(Registration registration) {
		registrationRepository.save(registration);

	}

	@Override
	public List<Registration> findAllRegistration() {
		List<Registration> registrations=registrationRepository.findAll();
		return registrations;
	}

	@Override
	public void deleteRegistration(long id) {
		registrationRepository.deleteById(id);
		
	}

	@Override
	public Registration getRegistrationById(long id) {
		Optional<Registration> byId = registrationRepository.findById(id);
		Registration registration = byId.get();
		return registration;
	}

	@Override
	public void updateRegistration(Registration registration) {
		registrationRepository.save(registration);
		
	}

}
