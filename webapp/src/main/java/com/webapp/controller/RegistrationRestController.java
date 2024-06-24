package com.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.exception.ResourceNotFound;
import com.webapp.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/marketing")
public class RegistrationRestController {

	// http://loclhost:8080/api/marketing
	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping
	public ResponseEntity<List<Registration>> getAllReg() {

		List<Registration> registration = registrationRepository.findAll();
		return new ResponseEntity<>(registration, HttpStatus.OK);

	}

	// http://localhost:8080/api/marketing?id=1
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam long id) {
		
		Optional<Registration> byId = registrationRepository.findById(id);
		
		if(byId.isPresent()) {

		registrationRepository.deleteById(id);
		}
		else {
			try {
				throw new ResourceNotFound();
			} catch (Exception e) {
				return new ResponseEntity<>("Could not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>("Registration is deleted", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Registration> saveRegistration(@RequestBody Registration registration) {
		Registration savedReg = registrationRepository.save(registration);
		return new ResponseEntity<>(savedReg, HttpStatus.CREATED);
	}
//	@PutMapping
//	public void updateRegistration(@RequestBody RegistrationDto dto) {
//		Registration reg = new Registration();
//		reg.setId(dto.getId());
//		reg.setFirstName(dto.getFirstName());
//		reg.setLastName(dto.getLastName());
//		reg.setEmail(dto.getEmail());
//		reg.setMobile(dto.getMobile());
//		registrationRepository.save(reg);
//	}

	// http://localhost:8080/api/marketing?=3
	@PutMapping
	public ResponseEntity<Registration> updateRegistration(@RequestBody RegistrationDto dto, @RequestParam long id) {
		Registration reg = new Registration();
		reg.setId(id);
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		registrationRepository.save(reg);
		return new ResponseEntity(reg, HttpStatus.OK);
	}

}
