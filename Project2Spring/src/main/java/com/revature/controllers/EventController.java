package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AppUser;
import com.revature.model.Event;
import com.revature.model.Interests;
import com.revature.services.EventServices;

@RestController
@CrossOrigin
@RequestMapping("events")
public class EventController {

	@Autowired
	private EventServices es;
	
	//create an event
	@CrossOrigin
	@PostMapping("create")
	public Event create(@RequestBody Event e) {
	return es.save(e);
	}
	
	//find all users
		@GetMapping
		public List<Event> findAll() {
			System.out.println("finding all events");
			List<Event> events = new ArrayList<>();
			return es.findAll();
		}
	
	@PostMapping
	public ResponseEntity<Interests> save(@RequestBody Interests i) {

		ResponseEntity<Interests> RE = new ResponseEntity<Interests>(i, HttpStatus.CREATED);

		return RE;
	}
}
