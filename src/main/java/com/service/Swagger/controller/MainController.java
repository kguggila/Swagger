package com.service.Swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Swagger.entities.Contact;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class MainController {
	
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(MainController.class);
	
	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	@GetMapping("/getContact/{id}")
	@ApiOperation(value = "Retreive Contact by ID", notes = "Retreive Contact by ID from Contact Manager System", response = String.class)
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}
	
	@GetMapping("/allContacts")
	@ApiOperation(value = "Retreive All Contacts", notes = "Retreive All Contacts from Contact Manager System", response = String.class)
	public List<Contact> getAllContacts() {
		return new ArrayList<Contact>(contacts.values());
	}
	
	@PostMapping("/addContact")
	@ApiOperation(value = "Save Contact", notes = "Save Contact to Contact Manager System", response = String.class)
	public Contact addContact(@RequestBody Contact contact) {
		LOGGER.info("Start Method Add Contact");
		contacts.put(contact.getId(), contact);
		LOGGER.info("End Method Add Contact");
		return contact;
	}
}
